package xyz.justblink.grace.internal.inline;

import xyz.justblink.grace.tag.Tag;

import java.util.Optional;

public interface InlineTagEmitter {
    void feedLine(String line);
    void registerCatcher(InlineTagCatcher catcher);
    Optional<Tag> stopAndEmit();
    boolean hasCache();
}
