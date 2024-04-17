package rs.qubit;

import java.util.HashMap;

public class Record extends HashMap<String, Object> {


    public Record put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
