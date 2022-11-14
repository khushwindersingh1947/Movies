package com.example.movies;

import com.google.gson.annotations.SerializedName;

public class APIResponse {
    @SerializedName("Search")
    private Movie[] movies;

    private String totalResult;

    @SerializedName("Response")
    private String response;

    public Movie[] getMovies() {
        return movies;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public String getResponse() {
        return response;
    }
}
