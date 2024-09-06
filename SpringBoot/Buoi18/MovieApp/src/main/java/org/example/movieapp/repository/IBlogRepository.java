package org.example.movieapp.repository;

import org.example.movieapp.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findByStatus(Boolean status, Pageable pageable);

    //chi tiet tin tuc
    Optional<Blog> findByIdAndSlugAndStatus(Integer id, String slug, Boolean status);

}
