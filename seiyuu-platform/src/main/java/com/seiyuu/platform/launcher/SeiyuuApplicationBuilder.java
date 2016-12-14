package com.seiyuu.platform.launcher;

import com.seiyuu.platform.launcher.exception.SeiyuuAppInitializationFailure;

/**
 * Created by ambidere on 12/12/16.
 */
public class SeiyuuApplicationBuilder
{
    private static final String APP = "app";

    public SeiyuuApp build( AppParameters params )
    {
        assertAppArgumentExists( params );
        String name = params.getParameterFirstValue( APP );
        SeiyuuApp app;
        try
        {
            Class clazz = Class.forName( name );
            app = (SeiyuuApp) clazz.newInstance();
        }
        catch ( ClassNotFoundException e )
        {
            throw new SeiyuuAppInitializationFailure( "Class not found" );
        }
        catch ( InstantiationException e )
        {
            throw new SeiyuuAppInitializationFailure( "Instantiation issue" );
        }
        catch ( IllegalAccessException e )
        {
            throw new SeiyuuAppInitializationFailure( "Illegal access" );
        }
        return app;
    }

    private void assertAppArgumentExists(AppParameters params )
    {
        if ( !params.parameterExists( APP ) )
        {
            throw new SeiyuuAppInitializationFailure( "Argument app not found upon start-up" );
        }
    }
}
