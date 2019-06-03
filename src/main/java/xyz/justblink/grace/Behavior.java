package xyz.justblink.grace;


import xyz.justblink.grace.tag.Tag;

import java.util.Optional;

public interface Behavior {
    Behavior action(final String line) throws Exception;

    Optional<Tag> output();

    void startOver();
}
