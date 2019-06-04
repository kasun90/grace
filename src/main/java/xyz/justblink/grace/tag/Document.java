package xyz.justblink.grace.tag;

public final class Document extends Tag {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
