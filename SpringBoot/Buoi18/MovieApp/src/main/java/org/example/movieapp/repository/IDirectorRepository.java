package org.example.movieapp.repository;

import org.example.movieapp.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDirectorRepository extends JpaRepository<Director, Integer> {

}
