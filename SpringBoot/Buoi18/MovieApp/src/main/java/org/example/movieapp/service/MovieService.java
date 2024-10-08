package org.example.movieapp.service;

import lombok.RequiredArgsConstructor;
import org.example.movieapp.entity.Movie;
import org.example.movieapp.model.enums.MovieType;
import org.example.movieapp.repository.IMovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class MovieService {

    private final IMovieRepository movieRepository;

    public Page<Movie> getMovieByType(MovieType type, Boolean status, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("createdAt").descending());
        return movieRepository.findByTypeAndStatus(type, status, pageable);

    }

    public Page<Movie> getMovieByStatus(Boolean status, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize,
                Sort.by("rating", "createdAt").descending());
        return movieRepository.findByStatus(status, pageable);
    }

    public Movie getMovieDetail(Integer id, String slug) {
        return movieRepository.findByIdAndSlugAndStatus(id, slug, true).orElse(null);
    }

    public List<Movie> getListMovieSuggestion(Integer id, MovieType type) {
        return movieRepository.findTop6ByIdNotAndTypeAndStatus(id, type, true);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll(Sort.by("createdAt").descending());
    }

    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id).orElse(null);

    }
}
