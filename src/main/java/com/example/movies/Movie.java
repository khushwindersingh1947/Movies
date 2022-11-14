package com.example.movies;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    private String imbdID;

    @SerializedName("Type")
    private String type;

    private String poster;


    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImbdID() {
        return imbdID;
    }

    public String getType() {
        return type;
    }

    public String getPoster() {
        return poster;
    }
}
