package org.example.movieapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.movieapp.entity.Blog;
import org.example.movieapp.entity.Movie;
import org.example.movieapp.model.enums.MovieType;
import org.example.movieapp.service.BlogService;
import org.example.movieapp.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class WebController {
    private final MovieService movieService;
    private final BlogService blogService;

    @GetMapping("/home")
    public String getHomePage(Model model) {
        List<Movie> listPhimHot = movieService.getMovieByStatus(true, 1, 4).getContent();
        List<Movie> listPhimBo = movieService.getMovieByType(MovieType.PHIM_BO, true, 1, 6).getContent();
        List<Movie> listPhimLe = movieService.getMovieByType(MovieType.PHIM_LE, true, 1, 6).getContent();
        List<Movie> listPhimChieuRap = movieService.getMovieByType(MovieType.PHIM_CHIEU_RAP, true, 1, 6).getContent();
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
        Page<Movie> pageDataPhimBo = movieService.getMovieByType(MovieType.PHIM_BO, true, page, pageSize);
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

    @GetMapping("/tin-tuc")
    public String getBlogPage(Model model,
                              @RequestParam(required = false, defaultValue = "1") int page,
                              @RequestParam(required = false, defaultValue = "10") int pageSize) {
        Page<Blog> pageDataBlog = blogService.getBlogByStatus(true, page, pageSize);
        model.addAttribute("pageDataBlog", pageDataBlog);
        model.addAttribute("currentPage", page);
        return "/web/blog";
    }
}
