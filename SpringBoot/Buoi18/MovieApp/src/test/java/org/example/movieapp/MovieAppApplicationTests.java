package org.example.movieapp;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.example.movieapp.entity.*;
import org.example.movieapp.model.enums.MovieType;
import org.example.movieapp.model.enums.UserRole;
import org.example.movieapp.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    void encode_user_password() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.setPassword(passwordEncoder.encode("123"));
            userRepository.save(user);
        }
    }

    @Test
    void saveMovies() {
        Random rd = new Random();
        Faker faker = new Faker();
        Slugify slugify = Slugify.builder().build();

        List<Country> countries = countryRepository.findAll();
        List<Actor> actors = actorRepository.findAll();
        List<Director> directors = directorRepository.findAll();
        List<Genre> genres = genreRepository.findAll();

        for (int i = 1; i <= 200; i++) {
            //Random 1 country
            Country rdCountry = countries.get(rd.nextInt(countries.size()));

            //Random genre (1 hoac nhieu the loai)
            List<Genre> rdGenres = new ArrayList<>();

            for (int j = 0; j < rd.nextInt(3) + 1; j++) {
                Genre rdGenre = genres.get(rd.nextInt(genres.size()));
                if (!rdGenres.contains(rdGenre)) {
                    rdGenres.add(rdGenre);
                }
            }


            //Random 5-7 actor
            List<Actor> rdActors = new ArrayList<>();
            for (int j = 0; j < rd.nextInt(3) + 5; j++) {
                Actor rdActor = actors.get(rd.nextInt(actors.size()));
                if (!rdActors.contains(rdActor)) {
                    rdActors.add(rdActor);
                }
            }

            //Random 1-3 director
            List<Director> rdDirectors = new ArrayList<>();
            for (int j = 0; j < rd.nextInt(3) + 1; j++) {
                Director rdDirector = directors.get(rd.nextInt(directors.size()));
                if (!rdDirectors.contains(rdDirector)) {
                    rdDirectors.add(rdDirector);
                }
            }


            String name = faker.name().fullName();
            Boolean status = faker.bool().bool();
            Movie movie = Movie.builder()
                    .name(name)
                    .slug(slugify.slugify(name))
                    .description(faker.lorem().paragraph())
                    .poster("https://placehold.co/600x400?text=" + name.substring(0, 1).toUpperCase())
                    .releaseYear(faker.number().numberBetween(2020, 2024))
                    .rating(faker.number().randomDouble(1, 0, 10))
                    .trailerUrl("https://www.youtube.com/embed/gCUg6Td5fgQ?si=OCtNkpFF03gq03ny")
                    .type(MovieType.values()[rd.nextInt(MovieType.values().length)])
                    .status(status)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .publishedAt(LocalDateTime.now())
                    .country(rdCountry)
                    .actors(rdActors)
                    .directors(rdDirectors)
                    .genres(rdGenres)
                    .build();

            movieRepository.save(movie);
        }
    }

    @Test
    void saveBlogs() {
        Faker faker = new Faker();
        Slugify slugify = Slugify.builder().build();
        Random random = new Random();

        List<User> users = userRepository.findByRole(UserRole.ADMIN);

        for (int i = 1; i <= 100; i++) {
            //Random 1 user
            User rdUser = users.get(random.nextInt(users.size()));

            String title = faker.name().title();
            Boolean status = faker.bool().bool();
            Blog blog = Blog.builder()
                    .title(title)
                    .slug(slugify.slugify(title))
                    .content(faker.lorem().paragraph())
                    .description(faker.lorem().paragraph())
                    .thumbnail("https://placehold.co/600x400?text=" + title.substring(0, 1).toUpperCase())
                    .status(status)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .publishedAt(LocalDateTime.now())
                    .user(rdUser)
                    .build();

            blogRepository.save(blog);
        }
    }

    @Test
    void saveUsers() {
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
            String nameUser = faker.name().fullName();
            User user = User.builder()
                    .name(nameUser)
                    .email(faker.internet().emailAddress())
                    .password("123")
                    .avatar("https://placehold.co/600x400?text=" + nameUser.substring(0, 1)
                            .toUpperCase())
                    .role(i == 0 || i == 1 ? UserRole.ADMIN : UserRole.USER)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            userRepository.save(user);
        }
    }

    @Test
    void saveReviews() {
        Faker faker = new Faker();
        Random rd = new Random();

        List<User> users = userRepository.findAll();
        List<Movie> movies = movieRepository.findAll();

        for (Movie movie : movies) {
//            create 10-20 review for each movie
            for (int i = 0; i < rd.nextInt(11) + 10; i++) {
                //random 1 user
                User rdUser = users.get(rd.nextInt(users.size()));
                Review review = Review.builder()
                        .content(faker.lorem().paragraph())
                        .rating(faker.number().numberBetween(0, 10))
                        .movie(movie)
                        .user(rdUser)
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build();
                reviewRepository.save(review);
            }
        }
    }

    @Test
    void saveFavorites() {

        List<User> users = userRepository.findAll();
        List<Movie> movies = movieRepository.findAll();


        for (int i = 0; i < 50; i++) {
            //random 1 user
            User rdUser = users.get(new Random().nextInt(users.size()));
            //random 1 movie
            Movie rdMovie = movies.get(new Random().nextInt(movies.size()));


            Favorite favorite = Favorite.builder()
                    .user(rdUser)
                    .movie(rdMovie)
                    .createdAt(LocalDateTime.now())
                    .build();

            favoriteRepository.save(favorite);
        }
    }

    @Test
    void saveEpisodes() {
        Faker faker = new Faker();
        Random rd = new Random();

        List<Movie> movies = movieRepository.findAll();

        for (Movie movie : movies) {
            if (movie.getType().equals(MovieType.PHIM_BO)) {
                // Random 10 -> 20 episodes for each movie
                for (int i = 0; i < rd.nextInt(11) + 10; i++) {
                    Episode episode = Episode.builder()
                            .name("Tap " + (i + 1))
                            .duration(rd.nextInt(31) + 30)
                            .displayOrder(i + 1)
                            .videoUrl("https://www.youtube.com/embed/gCUg6Td5fgQ?si=OCtNkpFF03gq03ny")
                            .movie(movie)

                            .status(true)
                            .createdAt(LocalDateTime.now())
                            .updatedAt(LocalDateTime.now())
                            .publishedAt(LocalDateTime.now())
                            .build();
                    episodeRepository.save(episode);
                }
            } else {
                Episode episode = Episode.builder()
                        .name("Tap full")
                        .duration(rd.nextInt(31) + 90)
                        .displayOrder(1)
                        .videoUrl("https://www.youtube.com/embed/gCUg6Td5fgQ?si=OCtNkpFF03gq03ny")
                        .movie(movie)

                        .status(true)
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .publishedAt(LocalDateTime.now())
                        .build();
                episodeRepository.save(episode);
            }
        }
    }

    @Test
    void saveHistory() {
        Faker faker = new Faker();

        List<User> users = userRepository.findAll();
        List<Movie> movies = movieRepository.findAll();
        List<Episode> episodes = episodeRepository.findAll();


        for (int i = 0; i < 50; i++) {
            //random 1 user
            User rdUser = users.get(new Random().nextInt(users.size()));
            //random 1 movie
            Movie rdMovie = movies.get(new Random().nextInt(movies.size()));
            //random 1 episode
            Episode rdEpisode = episodes.get(new Random().nextInt(episodes.size()));

            History history;
            if (rdEpisode.getMovie().getType().equals(MovieType.PHIM_BO)) {
                history = History.builder()
                        .user(rdUser)
                        .movie(rdMovie)
                        .episode(rdEpisode)
                        .duration(faker.number().randomDouble(0, 0, 60))
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build();

            } else {
                history = History.builder()
                        .user(rdUser)
                        .movie(rdMovie)
                        .episode(rdEpisode)
                        .duration(faker.number().randomDouble(0, 0, 120))
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build();

            }
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
        Slugify slugify = Slugify.builder().build();
        for (int i = 0; i < 80; i++) {
            String nameActor = faker.name().fullName();
            Actor actor = Actor.builder()
                    .name(nameActor)
                    .slug(slugify.slugify(nameActor))
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
        Slugify slugify = Slugify.builder().build();
        for (int i = 0; i < 20; i++) {
            String nameDirector = faker.name().fullName();
            Director director = Director.builder()
                    .name(nameDirector)
                    .slug(slugify.slugify(nameDirector))
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
            String nameGenre = faker.leagueOfLegends().champion();
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
    public void testMethodQuery() {
        List<Movie> movies = movieRepository.findByTypeAndStatus(MovieType.PHIM_BO, true);
        System.out.println("So luong phim: " + movies.size());
//

    }

    @Test
    public void testMethodQuery2() {
        List<Movie> lstMovie = movieRepository.findTop5ByTypeAndStatusOrderByCreatedAtDescRatingAsc(
                MovieType.PHIM_BO, true);

        System.out.println("So luong phim: " + lstMovie.size());

    }


}
