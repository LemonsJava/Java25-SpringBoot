package org.example.movieapp.service;

import lombok.RequiredArgsConstructor;
import org.example.movieapp.entity.Review;
import org.example.movieapp.repository.IReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ReviewService {
    private final IReviewRepository reviewRepository;

    public Page<Review> getReviewByMovieIdAndUserId(Integer movieId, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("createdAt").descending());
        return reviewRepository.findByMovieId(movieId, pageable);
    }
}
