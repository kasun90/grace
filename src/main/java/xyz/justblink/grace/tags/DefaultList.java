package xyz.justblink.grace.tags;


import xyz.justblink.grace.ATagType;

public class DefaultList extends RichTag {
    public DefaultList() {
        this(ATagType.UNORDERED_LIST);
    }

    DefaultList(ATagType type) {
        super(type);
    }
}
