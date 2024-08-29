package org.example.movieapp.repository;

import java.util.List;
import org.example.movieapp.entity.Movie;
import org.example.movieapp.model.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {

  List<Movie> findByName(String name);

  List<Movie> findByNameContainingIgnoreCase(String name);

  Movie findByNameAndReleaseYear(String name, Integer releaseYear);

  List<Movie> findByRatingBetween(Double min, Double max);

  List<Movie> findByReleaseYearGreaterThanEqual(Integer releaseYear);

  List<Movie> findByStatusOrderByReleaseYearDesc(Boolean status);

  long countByType(MovieType type);

  boolean existsByRatingGreaterThan(Double rating);

  //Tim kiem cac bo phim theo loai va status, sap xep theo thoi gian tao giam dan, rating tang dan, lay 5 ban ghi dau tien

  List<Movie> findTop5ByTypeAndStatusOrderByCreatedAtDescRatingAsc(MovieType type,
      Boolean status);
}
