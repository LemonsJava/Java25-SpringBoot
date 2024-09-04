package org.example.movieapp.service;

import lombok.RequiredArgsConstructor;
import org.example.movieapp.entity.Blog;
import org.example.movieapp.repository.IBlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class BlogService {
    private final IBlogRepository blogRepository;

    public Page<Blog> getBlogByStatus(Boolean status, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("createdAt").descending());
        return blogRepository.findByStatus(status, pageable);
    }
}
