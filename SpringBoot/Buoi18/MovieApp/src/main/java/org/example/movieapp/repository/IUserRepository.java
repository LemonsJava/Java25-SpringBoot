package org.example.movieapp.repository;

import org.example.movieapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

}