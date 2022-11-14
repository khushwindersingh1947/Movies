package com.example.movies;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    public static void getMoviesFromOMDB(String searchTerm) throws IOException, InterruptedException {
        searchTerm = searchTerm.replaceAll(" ","%20");
        String uri = "http://www.omdbapi.com/?apikey=b225b7dd&s=" + searchTerm;

        //configure the environment to make a HTTP request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //this saves whatever returned to a file
        HttpResponse<Path> response = client.send(httpRequest,HttpResponse
                                            .BodyHandlers
                                            .ofFile(Paths.get("movies.json")));

    }

    /**
     * This method will read the json file and create an API response
     * object. That APIResponse object will hold the Movie objects
     */
    public static APIResponse getMoviesFromFile(){

        //Create GSON object
        Gson gson = new Gson();
        APIResponse apiResponse = null;

        //use FileReader and JsonReader to access the movies.json file and create
        //try with resources (anything in this bracket)
        try(
                FileReader fileReader = new FileReader("movies.json");
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            apiResponse = gson.fromJson(jsonReader,APIResponse.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return apiResponse;
    }
}
