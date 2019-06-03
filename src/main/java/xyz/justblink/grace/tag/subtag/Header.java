package xyz.justblink.grace.tag.subtag;

import xyz.justblink.grace.TagType;
import xyz.justblink.grace.tag.Tag;

public class Header extends Tag {

    private String value;
    private int size;

    public Header(String value, int size) {
        super(TagType.HEADER);
        this.value = value;
        this.size = size;
    }
}
