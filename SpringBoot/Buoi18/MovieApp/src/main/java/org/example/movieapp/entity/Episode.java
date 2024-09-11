package org.example.movieapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@ToString
@Builder

@Entity
@Table(name = "episodes")

public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String name;

    Integer displayOrder;

    Integer duration;

    @Column(nullable = false)
    String videoUrl;

    @Column(nullable = false)
    Boolean status;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    LocalDateTime publishedAt;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    Movie movie;
}
