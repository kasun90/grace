package xyz.justblink.grace.tags.subtags;


import xyz.justblink.grace.TagType;
import xyz.justblink.grace.tags.BaseTag;

public class Link extends BaseTag {

    private String value;
    private String url;

    public Link(String value, String url) {
        super(TagType.LINK);
        this.value = value;
        this.url = url;
    }
}
