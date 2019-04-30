package xyz.justblink.grace.tags.subtags;


import xyz.justblink.grace.TagType;

public class DefaultList extends RichTag {
    public DefaultList() {
        this(TagType.UNORDERED_LIST);
    }

    DefaultList(TagType type) {
        super(type);
    }
}
