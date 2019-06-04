package xyz.justblink.grace.tag;

public abstract class AbstractVisitor implements Visitor {
    protected void visitChildren(Tag parent) {
        Tag tag = parent.getFirstChild();

        while (tag != null) {
            tag.accept(this);
            tag = tag.getNext();
        }
    }
}
