package com.seiyuu.seidown.mode;

import com.seiyuu.platform.application.mode.SeiyuuAppMode;
import com.seiyuu.platform.application.parameters.AppParameters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ambidere on 12/15/16.
 */
public class HeadlessMode implements SeiyuuAppMode
{
    private AppParameters parameters;

    private String url;

    private String from;

    private String to;

    private String numPages;

    public HeadlessMode( AppParameters parameters )
    {
        this.parameters = parameters;
    }

    @Override
    public void initialize()
    {
        url = parameters.getParameterFirstValue("url" );
        String pages = parameters.getParameterFirstValue( "pages" );
        if ( isColonCenterNotation( pages ) )
        {
            System.out.println( pages );
        }
        else if ( isNumberOnlyNotation( pages ) )
        {

        }
        System.out.println( "Initialize" );

    }

    private boolean isColonCenterNotation( String pages )
    {
        return regexCheck( pages,"(^[0-9]*)[:]([0-9]*$)" );
    }

    private boolean isNumberOnlyNotation( String pages )
    {
        return regexCheck( pages,"(^[0-9]*$)");
    }

    private boolean regexCheck( String str, String regex )
    {
        Pattern pattern = Pattern.compile( regex );
        Matcher match = pattern.matcher( str );
        return match.matches();
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
