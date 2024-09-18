package org.example.movieapp.rest;

import lombok.RequiredArgsConstructor;
import org.example.movieapp.entity.Review;
import org.example.movieapp.model.request.CreateReviewRequest;
import org.example.movieapp.model.request.UpdateReviewRequest;
import org.example.movieapp.model.response.ErrorResponse;
import org.example.movieapp.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class ReviewApi {
    private final ReviewService reviewService;

    @PostMapping("/api/reviews")
    public ResponseEntity<?> createReview(@RequestBody CreateReviewRequest request) {
        try {
            Review review = reviewService.createReview(request);
            return ResponseEntity.ok(review);
        } catch (Exception e) {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PutMapping("/api/reviews/{reviewId}")
    public ResponseEntity<?> updateReview(@RequestBody UpdateReviewRequest request, @PathVariable Integer reviewId) {
        try {
            Review review = reviewService.updateReview(request, reviewId);
            return ResponseEntity.ok(review);
        } catch (Exception e) {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @DeleteMapping("/api/reviews/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Integer reviewId) {
        try {
            reviewService.deleteReview(reviewId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
