package com.seiyuu.platform.application;

import com.seiyuu.platform.application.mode.SeiyuuAppMode;
import com.seiyuu.platform.application.parameters.AppParameters;

/**
 * Created by marionejrs on 12/12/16.
 */
public interface SeiyuuApp
{
    void initialize();
    void run();
    void shutdown();
    void setParams( AppParameters params );
    AppParameters getParams();
    boolean isHeadless();
    void setMode( SeiyuuAppMode mode );
    SeiyuuAppMode getMode();
}
