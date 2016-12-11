package launcher;

import generic.ObjectParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ambidere on 12/11/16.
 */
public class AppParametersParser implements ObjectParser<String[], Map<String, List<String>>>
{
    private static final String DEFAULT_DELIMITER = "-";

    @Override
    public Map<String, List<String>> parse(String[] input)
    {
        Map<String, List<String>> parameters = new HashMap<>();
        String key = "";
        for( String arg : input )
        {
            if ( arg.startsWith( DEFAULT_DELIMITER ) )
            {
                key = arg.replace( DEFAULT_DELIMITER, "" );
            }

            if ( parameters.get( key ) != null )
            {
                parameters.get( key ).add( arg );
            }
            else
            {
                parameters.put( key, new ArrayList<>() );
            }
        }
        return parameters;
    }
}
