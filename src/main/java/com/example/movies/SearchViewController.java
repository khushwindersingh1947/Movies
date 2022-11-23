package com.example.movies;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private ListView<Movie> listView;

    @FXML
    private Label msgLabel;

    @FXML
    private ImageView posterImageView;

    @FXML
    private HBox resultsBox;

    @FXML
    private TextField searchTextField;

    @FXML
    private VBox selectedVBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resultsBox.setVisible(false);
        msgLabel.setVisible(false);

        //configure a listener for listView to display art
        listView.getSelectionModel().selectedItemProperty()
                .addListener((obs,old,movieSelected)->{
            if(movieSelected != null){
                try{
                    posterImageView.setImage(new Image(movieSelected.getPoster()));
                }catch (IllegalArgumentException e){
                    posterImageView.setImage(new Image(Main.class.getResourceAsStream("images/default_poster.png")));
                }
                posterImageView.setVisible(true);
            }
            else{
                posterImageView.setVisible(false);
            }
        });

    }

    //read the search term from textField
    //send the search term to API
    //display movie object in the listView
    @FXML
    void search(ActionEvent event) throws IOException, InterruptedException {
        //clear the list
        listView.getItems().clear();

        //get search term from search Text Field
        String searchText = searchTextField.getText();

        APIResponse apiResponse = APIUtility.getMoviesFromOMDB(searchText);

        //populate the list
        if(apiResponse.getResponse()){
            listView.getItems().addAll(apiResponse.getMovies());
            Collections.sort(listView.getItems());
            //make visible
            resultsBox.setVisible(true);
            msgLabel.setVisible(false);
        }
        else{
            msgLabel.setVisible(true);
            msgLabel.setText(apiResponse.getError());
        }
    }

    @FXML
    void getDetails(ActionEvent event) {

    }
}