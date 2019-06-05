package xyz.justblink.grace.tag.subtag;


import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.Visitor;

public class Link extends Tag {

    private String value;
    private String url;

    public Link(String value, String url) {
        this.value = value;
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
