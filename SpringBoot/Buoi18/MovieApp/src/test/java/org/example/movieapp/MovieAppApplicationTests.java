package org.example.movieapp;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import org.example.movieapp.entity.Actor;
import org.example.movieapp.entity.Blog;
import org.example.movieapp.entity.Country;
import org.example.movieapp.entity.Director;
import org.example.movieapp.entity.Episode;
import org.example.movieapp.entity.Favorite;
import org.example.movieapp.entity.Genre;
import org.example.movieapp.entity.History;
import org.example.movieapp.entity.Movie;
import org.example.movieapp.entity.Review;
import org.example.movieapp.entity.User;
import org.example.movieapp.model.enums.MovieType;
import org.example.movieapp.model.enums.UserRole;
import org.example.movieapp.repository.IActorRepository;
import org.example.movieapp.repository.IBlogRepository;
import org.example.movieapp.repository.ICountryRepository;
import org.example.movieapp.repository.IDirectorRepository;
import org.example.movieapp.repository.IEpisodeRepository;
import org.example.movieapp.repository.IFavoriteRepository;
import org.example.movieapp.repository.IGenreRepository;
import org.example.movieapp.repository.IHistoryRepository;
import org.example.movieapp.repository.IMovieRepository;
import org.example.movieapp.repository.IReviewRepository;
import org.example.movieapp.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieAppApplicationTests {

  @Autowired
  private IMovieRepository movieRepository;

  @Autowired
  private IBlogRepository blogRepository;

  @Autowired
  private IUserRepository userRepository;

  @Autowired
  private IReviewRepository reviewRepository;

  @Autowired
  private IFavoriteRepository favoriteRepository;

  @Autowired
  private IEpisodeRepository episodeRepository;

  @Autowired
  private IHistoryRepository historyRepository;

  @Autowired
  private ICountryRepository countryRepository;

  @Autowired
  private IActorRepository actorRepository;

  @Autowired
  private IDirectorRepository directorRepository;

  @Autowired
  private IGenreRepository genreRepository;

  @Test
  void saveMovies() {
    Random rd = new Random();
    Faker faker = new Faker();
    Slugify slugify = Slugify.builder().build();
    for (int i = 1; i <= 200; i++) {
      String name = faker.name().fullName();
      Boolean status = faker.bool().bool();
      Movie movie = Movie.builder()
          .name(name)
          .slug(slugify.slugify(name))
          .description(faker.lorem().paragraph())
          .poster("https://placehold.co/600x400?text=" + name.substring(0, 1).toLowerCase())
          .releaseYear(faker.number().numberBetween(2020, 2024))
          .rating(faker.number().randomDouble(1, 0, 10))
          .trailerUrl("https://www.youtube.com/embed/gCUg6Td5fgQ?si=OCtNkpFF03gq03ny")
          .type(MovieType.values()[rd.nextInt(MovieType.values().length)])
          .status(status)
          .createdAt(LocalDateTime.now())
          .updatedAt(LocalDateTime.now())
          .publishedAt(LocalDateTime.now())
          .build();

      movieRepository.save(movie);
    }
  }

  @Test
  void saveBlogs() {
    Faker faker = new Faker();
    Slugify slugify = Slugify.builder().build();
    for (int i = 1; i <= 100; i++) {
      String title = faker.name().title();
      Boolean status = faker.bool().bool();
      Blog blog = Blog.builder()
          .title(title)
          .slug(slugify.slugify(title))
          .content(faker.lorem().paragraph())
          .description(faker.lorem().paragraph())
          .thumbnail("https://placehold.co/600x400?text=" + title.substring(0, 1).toLowerCase())
          .status(status)
          .createdAt(LocalDateTime.now())
          .updatedAt(LocalDateTime.now())
          .publishedAt(LocalDateTime.now())
          .build();

      blogRepository.save(blog);
    }
  }

  @Test
  void saveUsers() {
    Faker faker = new Faker();
    for (int i = 0; i < 100; i++) {
      User user = User.builder()
          .name(faker.name().fullName())
          .email(faker.internet().emailAddress())
          .password(faker.internet().password())
          .avatar("https://placehold.co/600x400?text=" + faker.name().username().substring(0, 1)
              .toLowerCase())
          .role(UserRole.valueOf("USER"))
          .createdAt(LocalDateTime.now())
          .updatedAt(LocalDateTime.now())
          .build();
      userRepository.save(user);
    }
  }

  @Test
  void saveReviews() {

    Faker faker = new Faker();
    for (int i = 0; i <= 50; i++) {
      Review review = Review.builder()
          .content(faker.lorem().paragraph())
          .rating(faker.number().randomDouble(1, 0, 10))
          .createdAt(LocalDateTime.now())
          .updatedAt(LocalDateTime.now())
          .build();

      reviewRepository.save(review);
    }
  }

  @Test
  void saveFavorites() {
    for (int i = 0; i < 50; i++) {
      Favorite favorite = Favorite.builder()
          .createdAt(LocalDateTime.now())
          .build();

      favoriteRepository.save(favorite);
    }
  }

  @Test
  void saveEpisodes() {
    Faker faker = new Faker();
    for (int i = 0; i < 30; i++) {
      Episode episode = Episode.builder()
          .title(faker.name().title())
          .displayOrder(faker.number().numberBetween(1, 50))
          .duration(faker.number().numberBetween(60, 300))
          .videoUrl("https://www.youtube.com/embed/gCUg6Td5fgQ?si=OCtNkpFF03gq03ny")
          .status(faker.bool().bool())
          .createdAt(LocalDateTime.now())
          .updatedAt(LocalDateTime.now())
          .publishedAt(LocalDateTime.now())
          .build();

      episodeRepository.save(episode);
    }
  }

  @Test
  void saveHistory() {
    Faker faker = new Faker();
    for (int i = 0; i < 50; i++) {
      History history = History.builder()
          .duration(faker.number().randomDouble(0, 0, 300))
          .createdAt(LocalDateTime.now())
          .updatedAt(LocalDateTime.now())
          .build();

      historyRepository.save(history);
    }
  }

  @Test
  void saveCountries() {
    Faker faker = new Faker();
    Slugify slugify = Slugify.builder().build();
    for (int i = 0; i < 30; i++) {
      String nameCountry = faker.country().name();
      Country country = Country.builder()
          .name(nameCountry)
          .slug(slugify.slugify(nameCountry))
          .createdAt(LocalDateTime.now())
          .updatedAt(LocalDateTime.now())
          .build();

      countryRepository.save(country);
    }
  }

  @Test
  void saveActors() {
    Faker faker = new Faker();
    for (int i = 0; i < 30; i++) {
      String nameActor = faker.name().fullName();
      Actor actor = Actor.builder()
          .name(nameActor)
          .biography(faker.lorem().paragraph())
          .avatar("https://placehold.co/600x400?text=" + nameActor.substring(0, 1).toUpperCase())
          .createdAt(LocalDateTime.now())
          .updatedAt(LocalDateTime.now())
          .build();

      actorRepository.save(actor);
    }
  }

  @Test
  void saveDirectors() {
    Faker faker = new Faker();
    for (int i = 0; i < 20; i++) {
      String nameDirector = faker.name().fullName();
      Director director = Director.builder()
          .name(nameDirector)
          .biography(faker.lorem().paragraph())
          .avatar("https://placehold.co/600x400?text=" + nameDirector.substring(0, 1).toUpperCase())
          .createdAt(LocalDateTime.now())
          .updatedAt(LocalDateTime.now())
          .build();

      directorRepository.save(director);
    }
  }

  @Test
  void saveGenres() {
    Faker faker = new Faker();
    Slugify slugify = Slugify.builder().build();
    for (int i = 0; i < 10; i++) {
      String nameGenre = faker.color().name();
      Genre genre = Genre.builder()
          .name(nameGenre)
          .slug(slugify.slugify(nameGenre))
          .createdAt(LocalDateTime.now())
          .updatedAt(LocalDateTime.now())
          .build();

      genreRepository.save(genre);
    }
  }

  @Test
  void test_methods() {
    List<Movie> movies = movieRepository.findAll();
    System.out.println("Movie size: " + movies.size());

    Movie movie1 = movieRepository.findById(1).orElse(null);
    System.out.println("Movie1: " + movie1);

//    Update
//    movie1.setName("Spiderman");
//    movieRepository.save(movie1);
  }

  @Test
  public void testMethodQuery() {
    long countPhimBo = movieRepository.countByType(MovieType.PHIM_BO);
    System.out.println("Phim bo: " + countPhimBo);
  }

  @Test
  public void testMethodQuery2() {
    List<Movie> lstMovie = movieRepository.findTop5ByTypeAndStatusOrderByCreatedAtDescRatingAsc(
        MovieType.PHIM_BO, true);

    System.out.println("So luong phim: " + lstMovie.size());

  }


}
