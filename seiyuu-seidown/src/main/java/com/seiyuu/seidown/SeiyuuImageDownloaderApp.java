package com.seiyuu.seidown;

import com.seiyuu.platform.application.SeiyuuApp;
import com.seiyuu.platform.application.mode.SeiyuuAppMode;
import com.seiyuu.platform.application.parameters.AppParameters;
import com.seiyuu.seidown.mode.HeadlessMode;

import java.awt.*;

/**
 * Created by ambidere on 12/12/16.
 */
public class SeiyuuImageDownloaderApp implements SeiyuuApp
{
    private AppParameters parameters;

    private SeiyuuAppMode currentMode;

    @Override
    public void initialize()
    {
        if ( isGui() )
        {
            //TODO: Do GUI mode here
        }
        else
        {
            currentMode = new HeadlessMode( parameters );
        }
        currentMode.initialize();
    }

    @Override
    public void run()
    {
        currentMode.run();
    }

    private boolean isGui()
    {
        return "on".equalsIgnoreCase( parameters.getParameterFirstValue( "gui" ) );
    }

    @Override
    public void shutdown()
    {
        currentMode.shutdown();
    }

    @Override
    public void setParams(AppParameters params)
    {
        parameters = params;
    }

    @Override
    public AppParameters getParams()
    {
        return parameters;
    }

    @Override
    public boolean isHeadless()
    {
        return GraphicsEnvironment.isHeadless();
    }

    @Override
    public void setMode(SeiyuuAppMode mode)
    {
        currentMode = mode;
    }

    @Override
    public SeiyuuAppMode getMode()
    {
        return currentMode;
    }

}
