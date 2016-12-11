package launcher;

/**
 * File launcher for Seiyuu related applications.
 *
 * Created by ambidere on 12/11/16.
 */
public class SeiyuuAppLauncher
{
    public static void main( String[] args )
    {
        AppParameters parameters = new SeiyuuAppParameters( args );
        System.out.println( parameters );
    }
}
