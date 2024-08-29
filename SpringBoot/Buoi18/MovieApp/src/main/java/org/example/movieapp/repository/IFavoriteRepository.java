package org.example.movieapp.repository;

import org.example.movieapp.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFavoriteRepository extends JpaRepository<Favorite, Integer> {

}
