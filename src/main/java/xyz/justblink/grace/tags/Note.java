package xyz.justblink.grace.tags;


import xyz.justblink.grace.ATagType;

public class Note extends SimpleATag {
    public Note(String value) {
        super(ATagType.NOTE);
        set("value", value);
    }
}
