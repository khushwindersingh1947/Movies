package com.example.movies;

import com.google.gson.annotations.SerializedName;

public class MovieDetail {
    @SerializedName("Title")
    private String title;

    @SerializedName("Rated")
    private String rated;

    @SerializedName("Runtime")
    private String runtime;

    @SerializedName("Genre")
    private String genre;

    @SerializedName("Director")
    private String director;

    @SerializedName("Writer")
    private String writer;

    @SerializedName("Actors")
    private String actors;

    @SerializedName("Poster")
    private String poster;

    @SerializedName("Ratings")
    private Rating[] ratings;

}
