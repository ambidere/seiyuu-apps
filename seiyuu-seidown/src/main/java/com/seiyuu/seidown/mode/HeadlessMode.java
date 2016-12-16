package com.seiyuu.seidown.mode;

import com.seiyuu.platform.application.mode.SeiyuuAppMode;
import com.seiyuu.platform.application.parameters.AppParameters;
import com.seiyuu.seidown.properties.SeiyuuDownloadProperties;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ambidere on 12/15/16.
 */
public class HeadlessMode implements SeiyuuAppMode
{
    private AppParameters parameters;

    private SeiyuuDownloadProperties properties;

    public HeadlessMode( AppParameters parameters )
    {
        this.parameters = parameters;
    }

    @Override
    public void initialize()
    {
        System.out.println( "Initialize" );
    }

    @Override
    public void run()
    {

    }

    @Override
    public void shutdown()
    {

    }
}
