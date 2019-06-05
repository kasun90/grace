package xyz.justblink.grace.tag.subtag;

import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.Visitor;

public class Image extends Tag {

    private String caption;
    private String resource;

    public Image(String resource, String caption) {
        this.caption = caption;
        this.resource = resource;
    }

    public String getCaption() {
        return caption;
    }

    public String getResource() {
        return resource;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
