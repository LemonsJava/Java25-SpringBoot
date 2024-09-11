package org.example.movieapp.repository;

import org.example.movieapp.entity.User;
import org.example.movieapp.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {

    List<User> findByRole(UserRole userRole);

}
