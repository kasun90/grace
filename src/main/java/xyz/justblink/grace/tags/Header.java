package xyz.justblink.grace.tags;

import xyz.justblink.grace.ATagType;

public class Header extends SimpleATag {
    public Header(String value, int size) {
        super(ATagType.HEADER);
        set("value", value);
        set("size", size);
    }
}
