package xyz.justblink.grace;


import xyz.justblink.grace.tag.Tag;

import java.util.Optional;

public interface BehaviorController {
    Behavior getBehavior(final String line) throws Exception;

    Optional<Tag> conclude() throws Exception;
}
