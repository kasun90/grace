package xyz.justblink.grace.tag.subtag;

import xyz.justblink.grace.tag.Visitor;

public class ItalicText extends Text {
    public ItalicText(String value) {
        super(value);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
