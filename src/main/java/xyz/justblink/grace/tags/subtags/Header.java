package xyz.justblink.grace.tags.subtags;

import xyz.justblink.grace.TagType;
import xyz.justblink.grace.tags.BaseTag;

public class Header extends BaseTag {

    private String value;
    private int size;

    public Header(String value, int size) {
        super(TagType.HEADER);
        this.value = value;
        this.size = size;
    }
}
