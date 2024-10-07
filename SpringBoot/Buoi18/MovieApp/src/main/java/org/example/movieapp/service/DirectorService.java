package org.example.movieapp.service;

import lombok.RequiredArgsConstructor;
import org.example.movieapp.entity.Director;
import org.example.movieapp.repository.IDirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class DirectorService {
    private final IDirectorRepository directorRepository;

    public List<Director> findAllDirectors() {
        return directorRepository.findAll();
    }
}
