package org.example.movieapp.repository;

import org.example.movieapp.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IEpisodeRepository extends JpaRepository<Episode, Integer> {

    List<Episode> findByMovieIdOrderByDisplayOrderAsc(Integer id);

    Optional<Episode> findByMovieIdAndStatusAndDisplayOrder(Integer movieId, Boolean status, Integer displayOrder);

}
