package xyz.justblink.grace.tag;

import java.io.Serializable;

public abstract class Tag implements Serializable {
    private Tag next;
    private Tag previous;
    private Tag parent;
    private Tag firstChild;
    private Tag lastChild;

    public abstract void accept(Visitor visitor);

    public Tag getNext() {
        return next;
    }

    public void setNext(Tag nextTag) {
        this.next = nextTag;
    }

    public Tag getPrevious() {
        return previous;
    }

    public void setPrevious(Tag previous) {
        this.previous = previous;
    }

    public Tag getParent() {
        return parent;
    }

    public void setParent(Tag parent) {
        this.parent = parent;
    }

    public Tag getFirstChild() {
        return firstChild;
    }

    public void appendChild(Tag child) {
        child.unlink();
        child.setParent(this);
        if (this.lastChild != null) {
            this.lastChild.next = child;
            child.previous = this.lastChild;
        } else {
            this.firstChild = child;
        }
        this.lastChild = child;
    }

    public void prependChild(Tag child) {
        child.unlink();
        child.setParent(this);
        if (this.firstChild != null) {
            this.firstChild.previous = child;
            child.next = this.firstChild;
        } else {
            this.lastChild = child;
        }
        this.firstChild = child;
    }

    public void unlink() {
        if (this.previous != null) {
            this.previous.next = this.next;
        } else if (this.parent != null) {
            this.parent.firstChild = this.next;
        }

        if (this.next != null) {
            this.next.previous = this.previous;
        } else if (this.parent != null) {
            this.parent.lastChild = this.previous;
        }

        this.parent = null;
        this.next = null;
        this.previous = null;
    }

    public boolean hasChildren() {
        return this.firstChild != null || this.lastChild != null;
    }

}