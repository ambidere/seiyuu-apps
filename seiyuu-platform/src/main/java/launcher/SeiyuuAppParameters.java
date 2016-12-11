package launcher;

import java.util.List;
import java.util.Map;

/**
 * Created by ambidere on 12/11/16.
 */
public class SeiyuuAppParameters implements AppParameters
{
    private Map<String, List<String>> parameters;

    @Override
    public Map<String, List<String>> getParameters() {
        return parameters;
    }

    @Override
    public boolean parameterExists() {
        return false;
    }

    @Override
    public List<String> getParameterValues(String key) {
        return null;
    }
}
