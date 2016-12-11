package generic;

/**
 * Created by ambidere on 12/11/16.
 */
public interface ObjectParser<I, O>
{
    O parse ( I input );
}
