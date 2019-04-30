package xyz.justblink.grace.tags.subtags;


import xyz.justblink.grace.TagType;
import xyz.justblink.grace.tags.BaseTag;

public class Gist extends BaseTag {

    private String source;
    private String file;

    public Gist(String source, String file) {
        super(TagType.GIST);
        this.source = source;
        this.file = file;
    }
}
