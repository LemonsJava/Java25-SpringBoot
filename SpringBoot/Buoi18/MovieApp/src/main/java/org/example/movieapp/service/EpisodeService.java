package org.example.movieapp.service;

import lombok.RequiredArgsConstructor;
import org.example.movieapp.entity.Episode;
import org.example.movieapp.repository.IEpisodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EpisodeService {
    private final IEpisodeRepository episodeRepository;

    public List<Episode> getEpisodesByMovieId(Integer movieId) {
        return episodeRepository.findByMovieIdOrderByDisplayOrderAsc(movieId);
    }

    public Episode getEpisodeByMovieIdAndStatusAndDisplayOrder(Integer movieId, String displayOrder) {
        Integer convertTap = displayOrder.equals("full") ? 1 : Integer.parseInt(displayOrder);
        return episodeRepository.findByMovieIdAndStatusAndDisplayOrder(movieId, true, convertTap).orElse(null);
    }
}
