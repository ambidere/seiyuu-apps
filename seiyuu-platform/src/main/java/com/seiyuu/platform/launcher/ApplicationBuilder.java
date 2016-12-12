package com.seiyuu.platform.launcher;

/**
 * Created by marionejrs on 12/12/16.
 */
public class ApplicationBuilder
{
    public SeiyuuApp buildApp( String name )
    {
        try
        {
            Class clazz = Class.forName( name );
            return (SeiyuuApp) clazz.newInstance();
        }
        catch ( ClassNotFoundException e )
        {
            System.out.println( "Class not found" );
        }
        catch ( InstantiationException e )
        {
            System.out.println( "Instantiation issue" );
        }
        catch ( IllegalAccessException e )
        {
            System.out.println( "Illegal access" );
        }
        return null;
    }
}
