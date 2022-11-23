package com.example.movies;

import com.google.gson.annotations.SerializedName;

public class Rating {
    @SerializedName("Source")
    private String source;

    @SerializedName("Value")
    private String value;
}
