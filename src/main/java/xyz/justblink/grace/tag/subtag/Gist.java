package xyz.justblink.grace.tag.subtag;


import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.Visitor;

public class Gist extends Tag {

    private String source;
    private String file;

    public Gist(String source, String file) {
        this.source = source;
        this.file = file;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
