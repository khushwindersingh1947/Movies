package com.example.movies;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
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
    }

    //read the search term from textField
    //send the search term to API
    //display movie object in the listView
    @FXML
    void search(ActionEvent event) throws IOException, InterruptedException {
        //get search term from search Text Field
        String searchText = searchTextField.getText();

        //populate the list
        listView.getItems().addAll(APIUtility.getMoviesFromOMDB(searchText));

        //make visible
        resultsBox.setVisible(true);
    }
}