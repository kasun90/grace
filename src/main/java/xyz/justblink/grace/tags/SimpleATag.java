package xyz.justblink.grace.tags;



import xyz.justblink.grace.ATagType;

import java.util.HashMap;

public abstract class SimpleATag extends ATag {
    SimpleATag(ATagType type) {
        super(type, new HashMap<>());
    }

    void set(String key, Object value) {
        getData().put(key, value);
    }

    Object get(String key) {
        return getData().get(key);
    }

    void setTagType(ATagType type) {
        setType(type);
    }
}
