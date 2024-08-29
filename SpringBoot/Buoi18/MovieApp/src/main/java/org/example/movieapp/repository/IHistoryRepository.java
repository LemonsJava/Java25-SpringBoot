package org.example.movieapp.repository;

import org.example.movieapp.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHistoryRepository extends JpaRepository<History, Integer> {

}
