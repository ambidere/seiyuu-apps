package com.seiyuu.platform.launcher;

import com.seiyuu.platform.generic.ObjectParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by ambidere on 12/11/16.
 */
public class SeiyuuAppParameters implements AppParameters
{
    private Map<String, List<String>> parameters;

    public SeiyuuAppParameters( String[] args )
    {
        initParams( args );
    }

    private void initParams( String[] args )
    {
        ObjectParser<String[], Map<String, List<String>>> parser = new AppParametersParser();
        parameters = parser.parse( args );
    }

    @Override
    public Map<String, List<String>> getParameters()
    {
        return parameters;
    }

    @Override
    public boolean parameterExists( String key )
    {
        return Optional.ofNullable( parameters )
                .map( m -> m.get(key) )
                .isPresent();
    }

    @Override
    public List<String> getParameterValues( String key )
    {
        return Optional.ofNullable( parameters.get( key ) )
                .orElse( new ArrayList<String>() );
    }

    @Override
    public void clearParameters()
    {
        parameters.clear();
    }

    @Override
    public String getParameterFirstValue( String key )
    {
        return Optional.ofNullable( parameters.get( key ) )
                .map( p -> p.stream() )
                .map( vs -> vs.findFirst() )
                .map( v -> v.orElse( "" ) )
                .orElse( "" );
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for ( String key : parameters.keySet() )
        {
            sb.append( "Key: " );
            sb.append( key );
            sb.append( "\n" );
            sb.append( "Values: " );
            sb.append( "\n" );
            for( String value : parameters.get( key ) )
            {
                sb.append( value );
                sb.append( " " );
            }
            sb.append( "\n" );
        }
        return sb.toString();
    }
}
