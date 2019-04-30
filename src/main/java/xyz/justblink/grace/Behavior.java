package xyz.justblink.grace;


import xyz.justblink.grace.tags.BaseTag;

import java.util.Optional;

public interface Behavior {
    Behavior action(final String line) throws Exception;

    Optional<BaseTag> output();

    void startOver();
}
