package com.example.movies;

import com.google.gson.annotations.SerializedName;

public class Movie implements Comparable<Movie>{
    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    private String imdbID;

    @SerializedName("Type")
    private String type;

    @SerializedName("Poster")
    private String poster;


    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getPoster() {
        return poster;
    }

    public String toString(){
        return getTitle() + "-" + getYear();
    }

    @Override
    public int compareTo(Movie otherMovie) {
        if(this.year.compareTo(otherMovie.getYear()) == 0){
            return this.title.compareTo(otherMovie.getTitle());
        }
        return this.year.compareTo(otherMovie.getYear());
    }
}
