package xyz.justblink.grace.tags;


import xyz.justblink.grace.ATagType;

public class Gist extends SimpleATag {
    public Gist(String source, String file) {
        super(ATagType.GIST);
        set("source", source);
        set("file", file);
    }
}
