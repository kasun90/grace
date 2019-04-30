package xyz.justblink.grace.tags.subtags;

import xyz.justblink.grace.TagType;
import xyz.justblink.grace.tags.BaseTag;

public class Image extends BaseTag {

    private String caption;
    private String resource;

    public Image(String resource, String caption) {
        super(TagType.IMAGE);
        this.caption = caption;
        this.resource = resource;
    }
}
