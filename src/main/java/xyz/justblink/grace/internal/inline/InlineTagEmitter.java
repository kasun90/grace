package xyz.justblink.grace.internal.inline;

import xyz.justblink.grace.tags.BaseTag;

import java.util.Optional;

public interface InlineTagEmitter {
    void feedLine(String line);
    void registerCatcher(InlineTagCatcher catcher);
    Optional<BaseTag> stopAndEmit();
    boolean hasCache();
}
