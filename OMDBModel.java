/*
 * Name:       Noah Lopez
 *
 * Course:     CSCI 13, Spring 2017
 *
 * Date:       5/6/18
 *
 * Filename:   OMDBModel.java
 *
 * Purpose:    Model for the final project
*/

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.net.URL;
import javafx.scene.image.Image;
import com.google.gson.*;
import java.lang.String;

public class OMDBModel
{
    private JsonElement jse = null;
    private final String apiKey = "bb79feb5";
    
    //Accessor for movie information
    public boolean getMovie(String movieTitle)
    {
        //URL won't accept spaces, it needs '+'
        movieTitle = movieTitle.replace(" ", "+");
        try
        {
            //Construct a OMDb movie url
            URL movieURL = new URL("http://www.omdbapi.com/?apikey="
                            + apiKey
                            + "&t="
                            + movieTitle
                            + "&type=movie");
            //http://www.omdbapi.com/?apikey=apiKey&t=movieTitle&type=movie
            /*
            * "s=" means search. It gives various results. Might be useful
            *http://www.omdbapi.com/?apikey=bb79feb5&s=Transformers
            */
            //http://www.omdbapi.com/?apikey=bb79feb5&t=Transformers&type=movie
            //http://www.omdbapi.com/?apikey=bb79feb5&t=The+Avengers&type=movie
            
            //Open the URL
            InputStream is = movieURL.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            //Close the URL
            jse = new JsonParser().parse(br);
            is.close();
            br.close();
        }
        catch (java.io.UnsupportedEncodingException uee)
		{
			uee.printStackTrace();
		}
		catch (java.net.MalformedURLException mue)
		{
			mue.printStackTrace();
		}
		catch (java.io.IOException ioe)
		{
			ioe.printStackTrace();
		}
        
        //Check to see if movie title was valid
        return isValid();
    }
    
    //Tests whether the movie title is valid
    public boolean isValid()
    {
        //String response = jse.getAsJsonObject().get("Response").getAsString();
        try
        {
            String response = jse.getAsJsonObject().get("Response").getAsString();
            if( response.equals("True") )
                return true;
            else
                return false;
        }
        catch (java.lang.NullPointerException npe)
        {
            return false;
        }
        
        /*
        if ( response.equals("False") )
        {
            return false;
        }
        else
        {
            return true;
        }*/
    }
    
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
    
    //Title accessor
    public String getTitle()
    {
        return jse.getAsJsonObject().get("Title").getAsString();
    }
    
    //Runtime accessor
    public String getRuntime()
    {
        return jse.getAsJsonObject().get("Runtime").getAsString();
    }
    
    //Poster Accessor
    public Image getPoster()
    {
        String posterURL = jse.getAsJsonObject().get("Poster").getAsString();
        return new Image(posterURL);
    }
    
    //Actors Accessor
    public String getActors()
    {
        return jse.getAsJsonObject().get("Actors").getAsString();
    }
    
    //Director Accessor
    public String getDirector()
    {
        return jse.getAsJsonObject().get("Director").getAsString();
    }
    
    //Writer accessor
    public String getWriters()
    {
        return jse.getAsJsonObject().get("Writer").getAsString();
    }
    
    //Rating Accessor
    public String getRating()
    {
        return jse.getAsJsonObject().get("Rated").getAsString();
    }
    
    //Genre Accessor
    public String getGenre()
    {
        return jse.getAsJsonObject().get("Genre").getAsString();
    }
    
    //Release Accessor
    public int getYear()
    {
        return Integer.parseInt( jse.getAsJsonObject().get("Year").getAsString() );
        //Change to include .get("Released") for whole release date?
    }
    
    //Unit test code---------------------------
    
    //Test driver for this class
    public static void main(String[] args)
    {
        OMDBModel m1 = new OMDBModel();
        m1.getMovie("The Avengers");
        //Test accessors
        System.out.println("Title:\t" + m1.getTitle());
        System.out.println("Runtime:\t" + m1.getRuntime());
        System.out.println("Actors:\t" + m1.getActors());
        System.out.println("Director(s):\t" + m1.getDirector());
        System.out.println("Writer(s):\t" + m1.getWriter());
        System.out.println("Genre:\t" + m1.getGenre());
        System.out.println("MPAA Rating:\t" + m1.getRating());
        System.out.println("Year released:\t" + m1.getYear());
    }
    
}