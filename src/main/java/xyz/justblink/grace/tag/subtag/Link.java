package xyz.justblink.grace.tag.subtag;


import xyz.justblink.grace.tag.Tag;

public class Link extends Tag {

    private String value;
    private String url;

    public Link(String value, String url) {
        this.value = value;
        this.url = url;
    }
}
