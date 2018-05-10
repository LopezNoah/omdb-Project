/*
 * Name:       Noah Lopez
 *
 * Course:     CSCI 13, Spring 2017
 *
 * Date:       5/6/18
 *
 * Filename:   OMDBController.java
 *
 * Purpose:    Controller for the final project
*/

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OMDBController
{
    /*
    *   Movie Title
    *   Movie runtime
    *   Movie Poster
    *   Cast
    *   Director
    *   Writers
    *   Genre
    *   Rating
    *   Release
    */
    
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblRuntime;
    @FXML
    private Label lblActors;
    @FXML
    private Label lblDirector;
    @FXML
    private Label lblWriter;
    @FXML
    private Label lblGenre;
    @FXML
    private Label lblRated;
    @FXML
    private Label lblYear;
    @FXML
    private ImageView moviePoster;
    @FXML
    private Button btnGo;
    @FXML
    private TextField txtMovie;
    
    @FXML
    private void handleButtonAction(ActionEvent e)
    {
        //Create object to access the Model
        OMDBModel movie = new OMDBModel();
        
        if( e.getSource() == btnGo )
        {
            String movieTitle = txtMovie.getText();
            if( movie.getMovie(movieTitle) )
            {
                lblTitle.setText(movie.getTitle());
                lblRuntime.setText(movie.getRuntime());
                lblGenre.setText(movie.getGenre());
                lblDirector.setText(movie.getDirector());
                lblWriter.setText(movie.getWriters());
                lblActors.setText(movie.getActors());
                lblRated.setText(movie.getRating());
                lblYear.setText( String.valueOf(movie.getYear()) );
                moviePoster.setImage(movie.getPoster());
            }
            else
            {
                lblTitle.setText("Invalid movie title");
                lblRuntime.setText("N/A");
                lblGenre.setText("N/A");
                lblDirector.setText("N/A");
                lblWriter.setText("N/A");
                lblActors.setText("N/A");
                lblRated.setText("N/A");
                lblYear.setText("N/A");
                moviePoster.setImage(new Image("invalidtitle.png"));
            }
        }
    }
/*
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //TODO
    }
*/
}