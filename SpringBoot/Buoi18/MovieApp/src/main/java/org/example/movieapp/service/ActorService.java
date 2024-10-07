package org.example.movieapp.service;

import lombok.RequiredArgsConstructor;
import org.example.movieapp.entity.Actor;
import org.example.movieapp.repository.IActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ActorService {
    private final IActorRepository actorRepository;

    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }
}
