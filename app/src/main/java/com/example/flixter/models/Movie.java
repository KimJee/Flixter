package com.example.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// PLain Old Java Object
public class Movie {
    String posterPath;
    String title;
    String overview;

    public Movie(JSONObject jsonObject) throws JSONException {
        // Create a movie data object

        // Grabs the poster path
        posterPath = jsonObject.getString("poster_path");
        // Grabs the title
        title = jsonObject.getString("title");
        // Grabs the overview
        overview = jsonObject.getString("overview");
    }

    // Iterates thorugh the JSON array and constructs movie from the JSON promise
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); ++i)
        {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
     }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
