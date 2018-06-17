package com.seiyuu.platform.application.launcher;

import com.seiyuu.platform.application.SeiyuuApp;
import com.seiyuu.platform.application.parameters.AppParameters;
import com.seiyuu.platform.application.parameters.SeiyuuAppParameters;

/**
 * Launcher for Seiyuu related applications.
 *
 * Created by ambidere on 12/11/16.
 */
public class SeiyuuAppLauncher
{
    public static void main( String[] args )
    {
        AppParameters parameters = new SeiyuuAppParameters( args );
        SeiyuuApplicationBuilder appBuilder = new SeiyuuApplicationBuilder();
        SeiyuuApp application = appBuilder.build( parameters );
        application.initialize();
        application.run();
        application.shutdown();
    }
}
