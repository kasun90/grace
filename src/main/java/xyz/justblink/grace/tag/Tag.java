package xyz.justblink.grace.tag;

import xyz.justblink.grace.TagType;

import java.io.Serializable;

public abstract class Tag implements Serializable {
    private TagType type;
    private Tag next;
    private Tag previous;
    private Tag parent;
    private Tag firstChild;
    private Tag lastChild;

    public Tag(TagType type) {
        this.type = type;
    }

    public void setNext(Tag nextTag) {
        this.next = nextTag;
    }

    public Tag getNext() {
        return next;
    }

    public void setPrevious(Tag previous) {
        this.previous = previous;
    }

    public Tag getPrevious() {
        return previous;
    }

    public void setParent(Tag parent) {
        this.parent = parent;
    }

    public Tag getParent() {
        return parent;
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

}