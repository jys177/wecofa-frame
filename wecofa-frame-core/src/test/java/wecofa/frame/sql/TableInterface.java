package wecofa.frame.sql;

import java.util.HashMap;
import java.util.Map;

public interface TableInterface {
    Map<String, String> keys = new HashMap<>();
    public Map<String,String> getKeys();
    public void putKey(String key, String value);
    public boolean containKeys(String key);
    public String getValue(String key);
}
