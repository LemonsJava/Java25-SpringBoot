package org.example.movieapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@ToString
@Builder

@Entity
@Table(name = "blogs")

public class Blog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(nullable = false, unique = true)
  String title;

  @Column(nullable = false, unique = true)
  String slug;

  @Column(columnDefinition = "TEXT")
  String content;

  @Column(columnDefinition = "TEXT")
  String description;

  String thumbnail;

  Boolean status;

  LocalDateTime createdAt;
  LocalDateTime updatedAt;
  LocalDateTime publishedAt;

}
