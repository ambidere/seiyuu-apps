package com.seiyuu.platform.launcher;

/**
 * File com.seiyuu.platform.launcher for Seiyuu related applications.
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
        application.start();
    }
}
