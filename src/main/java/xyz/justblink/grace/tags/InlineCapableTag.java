package xyz.justblink.grace.tags;

import xyz.justblink.grace.TagType;

import java.util.Collection;
import java.util.List;

public abstract class InlineCapableTag extends BaseTag {

    private List<BaseTag> children;

    public InlineCapableTag(TagType type, List<BaseTag> children) {
        super(type);
        this.children = children;
    }

    public void add(BaseTag tag) {
        this.children.add(tag);
    }

    public void addAll(List<BaseTag> tags) {
        this.children.addAll(tags);
    }
}
