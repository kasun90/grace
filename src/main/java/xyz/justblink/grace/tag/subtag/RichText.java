package xyz.justblink.grace.tag.subtag;

import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.Visitor;

public class RichText extends Tag {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
