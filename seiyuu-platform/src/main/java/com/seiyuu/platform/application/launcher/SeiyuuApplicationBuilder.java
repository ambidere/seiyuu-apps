package com.seiyuu.platform.application.launcher;

import com.seiyuu.platform.application.SeiyuuApp;
import com.seiyuu.platform.application.launcher.exception.SeiyuuAppInitializationFailure;
import com.seiyuu.platform.application.parameters.AppParameters;

/**
 * Created by ambidere on 12/12/16.
 */
public class SeiyuuApplicationBuilder
{
    private static final String APP = "app";

    public SeiyuuApp build(AppParameters params )
    {
        assertAppArgumentExists( params );
        String name = params.getParameterFirstValue( APP );
        SeiyuuApp app;
        try
        {
            Class clazz = Class.forName( name );
            app = (SeiyuuApp) clazz.newInstance();
            app.setParams( params );
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
