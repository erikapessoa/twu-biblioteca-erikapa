package com.twu.biblioteca.model;

import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Movie {
    private String title;
    private String director;
    private Year publicationYear;
    private Rate rating;
    private Integer movieId;
    private boolean available;

    public Movie(Integer movieId, String title, String director, Year publicationYear, Rate rating) {
        this.title = title;
        this.director = director;
        this.publicationYear = publicationYear;
        this.rating = rating;
        this.movieId = movieId;
        this.available = true;
    }

    public String publicationYear() {
        return publicationYear.format(DateTimeFormatter.ofPattern("u"));
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public Year getPublicationYear() {
        return publicationYear;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String rating() {
        String rate;

        switch (this.rating) {
            case ONE:
                rate = "*";
                break;
            case TWO:
                rate = "**";
                break;
            case THREE:
                rate = "***";
                break;
            case FOUR:
                rate = "****";
                break;
            case FIVE:
                rate = "*****";
                break;
            case SIX:
                rate = "******";
                break;
            case SEVEN:
                rate = "*******";
                break;
            case EIGHT:
                rate = "********";
                break;
            case NINE:
                rate = "*********";
                break;
            case TEN:
                rate = "**********";
                break;
            default:
                 rate = "Unrated";
                break;
        }
        return rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return title.equals(movie.title) &&
                director.equals(movie.director) &&
                publicationYear.equals(movie.publicationYear) &&
                movieId.equals(movie.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, director, publicationYear, movieId);
    }
}
