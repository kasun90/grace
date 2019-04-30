package xyz.justblink.grace.tags;

import xyz.justblink.grace.TagType;

import java.util.Map;

public abstract class BaseTag {
    private TagType type;

    public BaseTag(TagType type) {
        this.type = type;
    }
}