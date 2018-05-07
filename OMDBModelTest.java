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
    /*
    @Test
    public void testGetTitle()
    {
    }
    
    @Test
    public void testGetYear()
    {
    }
    
    @Test
    public void testGetDirector()
    {
    }
    
    @Test
    public void testGetActors()
    {
    }
    
    @Test
    public void testGetGenre()
    {
    }
    
    @Test
    public void testGetRuntime()
    {
    }
    
    @Test
    public void testGetRating()
    {
    }
*/
}
