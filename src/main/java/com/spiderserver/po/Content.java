package com.spiderserver.po;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by apoptoxin on 2014/11/27.
 */
public class Content {
    private Map<String, String> map = new HashMap<String, String>();

    public Set<String> getKeys() {
        return map.keySet();
    }

    public String getValueByKey(String key) {
        return map.get(key);
    }
}
