package com.example.movies;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class APIResponse {
    @SerializedName("Search")
    private Movie[] movies;

    private String totalResult;

    @SerializedName("Response")
    private String response;

    public List<Movie> getMovies() {
        return Arrays.asList(movies);
    }

    public String getTotalResult() {
        return totalResult;
    }

    public String getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "movies=" + Arrays.toString(movies) +
                ", totalResult='" + totalResult + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
