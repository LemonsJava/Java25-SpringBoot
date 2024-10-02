package org.example.movieapp.repository;

import org.example.movieapp.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReviewRepository extends JpaRepository<Review, Integer> {

    Page<Review> findByMovieId(Integer movieId, Pageable pageable);

    List<Review> findByMovieId(Integer movieId, Sort sort);


}
