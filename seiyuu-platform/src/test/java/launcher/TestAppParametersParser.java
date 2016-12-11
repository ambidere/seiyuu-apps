package launcher;

import org.junit.After;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by ambidere on 12/11/16.
 */
public class TestAppParametersParser
{
    private SeiyuuAppParameters parameters;

    @Test
    public void testGetParameterFirstValue()
    {
        String args[] = { "-conf", "conf.xml", "-app", "app" };
        parameters = new SeiyuuAppParameters( args );

        assertEquals( "conf.xml" , parameters.getParameterFirstValue( "conf" ) );
        assertEquals( "app" , parameters.getParameterFirstValue( "app" ) );
    }

    @Test
    public void testParameterKeyWithMultipleValue()
    {
        String args[] = { "-conf", "conf.xml", "conf2.xml", "-app", "app", "-test", "test1", "test2", "test3" };
        parameters = new SeiyuuAppParameters( args );

        assertEquals( Arrays.asList( "conf.xml", "conf2.xml" ) , parameters.getParameterValues( "conf" ) );
        assertEquals( Arrays.asList( "app" ) , parameters.getParameterValues( "app" ) );
        assertEquals( Arrays.asList( "test1", "test2", "test3" ), parameters.getParameterValues( "test" ) );
    }

    @After
    public void tearDown()
    {
        parameters.clearParameters();
    }
}
