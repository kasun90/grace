package xyz.justblink.grace.tag.subtag;


import xyz.justblink.grace.TagType;
import xyz.justblink.grace.tag.Tag;

public class Text extends Tag {

    private String value;

    public Text(String value) {
        this(TagType.TEXT, value);
    }

    public Text(TagType type, String value) {
        super(type);
        this.value = value;
    }
}