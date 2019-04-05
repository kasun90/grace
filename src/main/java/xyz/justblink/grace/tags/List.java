package xyz.justblink.grace.tags;

import com.blink.shared.article.ATagType;

public class List extends RichTag {
    public List() {
        this(ATagType.LIST);
    }

    public List(ATagType type) {
        super(type);
    }
}
