package xyz.justblink.grace.render.raw;

import xyz.justblink.grace.tag.TagType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExportableTag implements Serializable {
    private TagType type;
    private Map<String, Object> data;
    private List<ExportableTag> children;

    private ExportableTag(TagType type) {
        this.type = type;
    }

    public static ExportableTag create(TagType type) {
        return new ExportableTag(type);
    }

    public void set(String key, Object value) {
        if (data == null)
            data = new HashMap<>();
        data.put(key, value);
    }

    public void addChild(ExportableTag exportableTag) {
        if (children == null)
            children = new LinkedList<>();
        children.add(exportableTag);
    }
}
