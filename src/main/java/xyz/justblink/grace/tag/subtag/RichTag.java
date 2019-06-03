package xyz.justblink.grace.tag.subtag;


import xyz.justblink.grace.TagType;
import xyz.justblink.grace.tag.Tag;

import java.util.LinkedList;
import java.util.List;

public class RichTag extends Tag {

    private List<Tag> children;

    RichTag(TagType type) {
        super(type);
        children = new LinkedList<>();
    }

    public void addChild(Tag tag) {
        children.add(tag);
    }

    public int getChildrenLength() {
        return children.size();
    }
}
