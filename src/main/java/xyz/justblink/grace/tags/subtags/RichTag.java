package xyz.justblink.grace.tags.subtags;


import xyz.justblink.grace.TagType;
import xyz.justblink.grace.tags.BaseTag;

import java.util.LinkedList;
import java.util.List;

public class RichTag extends BaseTag {

    private List<BaseTag> children;

    RichTag(TagType type) {
        super(type);
        children = new LinkedList<>();
    }

    public void addChild(BaseTag tag) {
        children.add(tag);
    }

    public int getChildrenLength() {
        return children.size();
    }
}
