package com.example.movies;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    public static void getMoviesFromOMDB(String searchTerm) throws IOException, InterruptedException {
        String uri = "http://www.omdbapi.com/?apikey=b225b7dd&s=" + searchTerm;

        //configure the environment to make a HTTP request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //this saves whatever returned to a file
        HttpResponse<Path> response = client.send(httpRequest,HttpResponse
                                            .BodyHandlers
                                            .ofFile(Paths.get("movies.json")));




    }
}
