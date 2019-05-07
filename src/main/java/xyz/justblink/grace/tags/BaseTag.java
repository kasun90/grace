package xyz.justblink.grace.tags;

import xyz.justblink.grace.TagType;

import java.io.Serializable;

public abstract class BaseTag implements Serializable {
    private TagType type;

    public BaseTag(TagType type) {
        this.type = type;
    }
}