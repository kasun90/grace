package xyz.justblink.grace.tag.subtag;

import xyz.justblink.grace.tag.Visitor;

public class OrderedList extends DefaultList {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
