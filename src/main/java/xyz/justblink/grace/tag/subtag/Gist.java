package xyz.justblink.grace.tag.subtag;


import xyz.justblink.grace.TagType;
import xyz.justblink.grace.tag.Tag;

public class Gist extends Tag {

    private String source;
    private String file;

    public Gist(String source, String file) {
        super(TagType.GIST);
        this.source = source;
        this.file = file;
    }
}
