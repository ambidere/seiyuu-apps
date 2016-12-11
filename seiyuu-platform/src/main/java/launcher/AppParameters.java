package launcher;

/**
 * Created by ambidere on 12/11/16.
 */

import java.util.List;
import java.util.Map;

public interface AppParameters {
    Map<String, List<String>> getParameters();
    boolean parameterExists( String key );
    List<String> getParameterValues( String key );
    void clearParameters();
    String getParameterFirstValue( String key );
}
