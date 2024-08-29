package org.example.movieapp.repository;

import org.example.movieapp.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

}
