package com.seiyuu.seidown.properties;

import com.seiyuu.platform.application.parameters.AppParameters;
import com.seiyuu.seidown.properties.exception.InvalidPageNotationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ambidere on 12/16/16.
 */
public class HeadlessSeiyuuDownloadPropBuilder implements SeiyuuDownloadPropBuilder
{
    private static final String COLON_CENTER_NOTATION_REGEX = "(^[0-9]*)([:])([0-9]*$)";

    private static final String NUMBER_ONLY_NOTATION_REGEX = "(^[0-9]*$)";

    private AppParameters parameters;

    public HeadlessSeiyuuDownloadPropBuilder( AppParameters params )
    {
        parameters = params;
    }

    @Override
    public SeiyuuDownloadProperties buildDownloadPriority()
    {
        String url = parameters.getParameterFirstValue("url" );
        SeiyuuDownloadProperties props = new SeiyuuDownloadProperties( url );
        String pages = parameters.getParameterFirstValue( "pages" );
        if ( isColonCenterNotation( pages ) )
        {
            Matcher match = createMatcher( COLON_CENTER_NOTATION_REGEX, pages );
            if ( match.find() )
            {
                int firstPage = Integer.parseInt( match.group(1 ) );
                int lastPage = Integer.parseInt( match.group(3 ) );
                if ( firstPage <= lastPage )
                {
                    props.setFirstPage( firstPage );
                    props.setLastPage( lastPage );
                    props.setNumberOfPages( lastPage - firstPage + 1 );
                }
                else
                {
                    throw new InvalidPageNotationException();
                }
            }
        }
        else if ( isNumberOnlyNotation( pages ) )
        {
            Matcher match = createMatcher( COLON_CENTER_NOTATION_REGEX, pages );
            if ( match.find() )
            {
                props.setFirstPage( 1 );
                props.setLastPage( Integer.parseInt( match.group(0 ) ) );
                props.setNumberOfPages( Integer.parseInt( match.group(0 ) ) );
            }
        }
        return props;
    }

    private boolean isColonCenterNotation( String pages )
    {
        return regexCheck( pages, COLON_CENTER_NOTATION_REGEX );
    }

    private boolean isNumberOnlyNotation( String pages )
    {
        return regexCheck( pages,NUMBER_ONLY_NOTATION_REGEX);
    }

    private boolean regexCheck( String regex, String string )
    {
        return createMatcher( regex, string ).matches();
    }

    private Matcher createMatcher( String regex, String string )
    {
        Pattern pattern = Pattern.compile( regex );
        return pattern.matcher( string );
    }
}
