package org.example.movieapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.movieapp.entity.*;
import org.example.movieapp.model.enums.MovieType;
import org.example.movieapp.service.BlogService;
import org.example.movieapp.service.EpisodeService;
import org.example.movieapp.service.MovieService;
import org.example.movieapp.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class WebController {

    private final MovieService movieService;
    private final BlogService blogService;
    private final EpisodeService episodeService;
    private final ReviewService reviewService;
    private final HttpSession session;

    @GetMapping("/home")
    public String getHomePage(Model model) {
        List<Movie> listPhimHot = movieService.getMovieByStatus(true, 1, 4).getContent();
        List<Movie> listPhimBo = movieService.getMovieByType(MovieType.PHIM_BO, true, 1, 6)
                .getContent();
        List<Movie> listPhimLe = movieService.getMovieByType(MovieType.PHIM_LE, true, 1, 6)
                .getContent();
        List<Movie> listPhimChieuRap = movieService.getMovieByType(MovieType.PHIM_CHIEU_RAP, true, 1, 6)
                .getContent();
        List<Blog> listBlog = blogService.getBlogByStatus(true, 1, 4).getContent();
        model.addAttribute("listPhimHot", listPhimHot);
        model.addAttribute("listPhimBo", listPhimBo);
        model.addAttribute("listPhimLe", listPhimLe);
        model.addAttribute("listPhimChieuRap", listPhimChieuRap);
        model.addAttribute("listBlog", listBlog);
        return "web/index";
    }


    // /phim-bo?page=1&size=12
    @GetMapping("/phim-bo")
    public String getPhimBoPage(@RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "12") int pageSize,
                                Model model) {
        Page<Movie> pageDataPhimBo = movieService.getMovieByType(MovieType.PHIM_BO, true, page,
                pageSize);
        model.addAttribute("pageDataPhimBo", pageDataPhimBo);
        model.addAttribute("currentPage", page);
        return "/web/phim-bo";
    }

    @GetMapping("/phim-le")
    public String getPhimLePage(@RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "12") int pageSize,
                                Model model) {
        Page<Movie> pageDataPhimLe = movieService.getMovieByType(MovieType.PHIM_LE, true, page, pageSize);
        model.addAttribute("pageDataPhimLe", pageDataPhimLe);
        model.addAttribute("currentPage", page);
        return "/web/phim-le";
    }

    @GetMapping("/phim-chieu-rap")
    public String getPhimChieuRapPage(@RequestParam(required = false, defaultValue = "1") int page,
                                      @RequestParam(required = false, defaultValue = "12") int pageSize,
                                      Model model) {
        Page<Movie> pageDataPhimChieuRap = movieService.getMovieByType(MovieType.PHIM_CHIEU_RAP, true, page, pageSize);
        model.addAttribute("pageDataPhimChieuRap", pageDataPhimChieuRap);
        model.addAttribute("currentPage", page);
        return "/web/phim-chieu-rap";
    }

    @GetMapping("/phim/{id}/{slug}")
    public String getPhimDetail(Model model,
                                @PathVariable Integer id,
                                @PathVariable String slug) {
        Movie movieDetail = movieService.getMovieDetail(id, slug);
        List<Episode> listEpisodes = episodeService.getEpisodesByMovieId(movieDetail.getId());
        List<Movie> listMovieSuggestion = movieService.getListMovieSuggestion(movieDetail.getId(), movieDetail.getType());
        List<Review> listReviews = reviewService.getReviewByMovieId(id);
        model.addAttribute("movieDetail", movieDetail);
        model.addAttribute("listEpisodes", listEpisodes);
        model.addAttribute("listMovieSuggestion", listMovieSuggestion);
        model.addAttribute("listReviews", listReviews);
        return "/web/chi-tiet-phim";
    }

    @GetMapping("/xem-phim/phim/{id}/{slug}")
    public String getMovieStreamDetailPage(Model model,
                                           @PathVariable Integer id,
                                           @PathVariable String slug,
                                           @RequestParam String tap) {
        Movie movieDetail = movieService.getMovieDetail(id, slug);
        List<Episode> listEpisodes = episodeService.getEpisodesByMovieId(movieDetail.getId());
        Episode episode = episodeService.getEpisodeByMovieIdAndStatusAndDisplayOrder(id, tap);
        List<Movie> listMovieSuggestion = movieService.getListMovieSuggestion(movieDetail.getId(), movieDetail.getType());
        List<Review> listReviews = reviewService.getReviewByMovieId(id);
        model.addAttribute("movieDetail", movieDetail);
        model.addAttribute("listEpisodes", listEpisodes);
        model.addAttribute("listMovieSuggestion", listMovieSuggestion);
        model.addAttribute("listReviews", listReviews);
        model.addAttribute("episode", episode);
        return "/web/xem-phim";
    }

    @GetMapping("/tin-tuc")
    public String getBlogPage(Model model,
                              @RequestParam(required = false, defaultValue = "1") int page,
                              @RequestParam(required = false, defaultValue = "10") int pageSize) {
        Page<Blog> pageDataBlog = blogService.getBlogByStatus(true, page, pageSize);
        model.addAttribute("pageDataBlog", pageDataBlog);
        model.addAttribute("currentPage", page);
        return "/web/blog";
    }

    @GetMapping("/tin-tuc/{id}/{slug}")
    public String getBlogDetail(Model model,
                                @PathVariable Integer id,
                                @PathVariable String slug) {
        Blog blogDetail = blogService.getBlogDetail(id, slug);
        model.addAttribute("blogdetail", blogDetail);
        return "/web/chi-tiet-tin-tuc";
    }

    @GetMapping("/dang-nhap")
    public String getLoginPage(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("currentUser");
        if (user != null) {
            return "redirect:/home";
        }
        return "/web/dang-nhap";
    }

    @GetMapping("/thong-tin-ca-nhan")
    public String getProfilePage(Model model) {
        User user = (User) session.getAttribute("currentUser");
        model.addAttribute("user", user);
        return "/web/thong-tin-ca-nhan";
    }
}
