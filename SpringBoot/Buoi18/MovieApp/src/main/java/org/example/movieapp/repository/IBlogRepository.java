package org.example.movieapp.repository;

import org.example.movieapp.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findByStatus(Boolean status, Pageable pageable);

}
