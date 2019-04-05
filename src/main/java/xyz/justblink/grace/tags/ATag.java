package xyz.justblink.grace.tags;

import xyz.justblink.grace.ATagType;

import java.util.Map;

class ATag {
    private ATagType type;
    private Map<String, Object> data;


    ATag(ATagType type, Map<String, Object> data) {
        this.type = type;
        this.data = data;
    }


    void setType(ATagType type) {
        this.type = type;
    }

    Map<String, Object> getData() {
        return data;
    }
}