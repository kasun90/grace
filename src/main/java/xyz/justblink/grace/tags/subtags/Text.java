package xyz.justblink.grace.tags.subtags;


import xyz.justblink.grace.TagType;
import xyz.justblink.grace.tags.BaseTag;

public class Text extends BaseTag {

    private String value;

    public Text(String value) {
        this(TagType.TEXT, value);
    }

    public Text(TagType type, String value) {
        super(type);
        this.value = value;
    }
}
