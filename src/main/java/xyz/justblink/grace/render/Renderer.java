package xyz.justblink.grace.render;

import xyz.justblink.grace.tag.Tag;

public interface Renderer<T> {
    T render(Tag tag);
}
