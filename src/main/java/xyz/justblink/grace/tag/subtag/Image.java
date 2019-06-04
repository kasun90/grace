package xyz.justblink.grace.tag.subtag;

import xyz.justblink.grace.tag.Tag;

public class Image extends Tag {

    private String caption;
    private String resource;

    public Image(String resource, String caption) {
        this.caption = caption;
        this.resource = resource;
    }
}
