package xyz.justblink.grace.tag.subtag;


import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.Visitor;

import java.util.LinkedList;
import java.util.List;

public class Code extends Tag {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
