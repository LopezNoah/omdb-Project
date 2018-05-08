import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class OMDBModelTest
{
    @Test
    public void testGetMovie1()
    {
        OMDBModel m = new OMDBModel();
        assertEquals(true, m.getMovie("Titanic"));
    }
    
    @Test
    public void testGetMovie2()
    {
        OMDBModel m = new OMDBModel();
        assertEquals(false, m.getMovie("Fake Movie Title"));
    }
    
    @Test
    public void testGetTitle()
    {
        OMDBModel m = new OMDBModel();
        m.getMovie("Titanic");
        assertEquals("Titanic", m.getTitle());
    }
    
    @Test
    public void testGetYear()
    {
        OMDBModel m = new OMDBModel();
        m.getMovie("The Avengers");
        String year = String.valueOf(m.getYear());
        boolean yearInt = year.matches("\\d+");
        //assertEquals(true, yearInt);
        assertEquals(2012, m.getYear());
    }
    
    @Test
    public void testGetDirector()
    {
        OMDBModel m = new OMDBModel();
        m.getMovie("Spider-Man");
        assertEquals("Sam Raimi", m.getDirector());
    }
    
    @Test
    public void testGetActors()
    {
        OMDBModel m = new OMDBModel();
        m.getMovie("Avengers");
        assertEquals("Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth",
                     m.getActors());
    }
    
    @Test
    public void testGetGenre()
    {
        OMDBModel m = new OMDBModel();
        m.getMovie("Grease");
        assertEquals("Musical, Romance", m.getGenre());
    }
    
    @Test
    public void testGetRuntime()
    {
        OMDBModel m = new OMDBModel();
        m.getMovie("Grease");
        assertEquals("110 min", m.getRuntime());
    }
    
    @Test
    public void testGetRating()
    {
        OMDBModel m = new OMDBModel();
        m.getMovie("Avengers");
        assertEquals("PG-13", m.getRating());
    }
*/
}
