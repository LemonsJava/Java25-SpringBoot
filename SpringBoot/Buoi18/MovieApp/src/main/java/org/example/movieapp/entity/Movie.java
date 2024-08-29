package org.example.movieapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.example.movieapp.model.enums.MovieType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Builder

@Entity
@Table(name = "movies")

public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(unique = true)
  String name;

  @Column(nullable = false, unique = true)
  String slug;

  @Column(columnDefinition = "TEXT")
  String description;

  String poster;

  @Column(name = "release_year")
  Integer releaseYear;

  Double rating;

  @Column(name = "trailer_url")
  String trailerUrl;

  @Enumerated(EnumType.STRING)
  MovieType type;

  Boolean status;
  LocalDateTime createdAt;
  LocalDateTime updatedAt;
  LocalDateTime publishedAt;

}
