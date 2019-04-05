package xyz.justblink.grace;


import xyz.justblink.grace.tags.SimpleATag;

import java.util.Optional;

public interface BehaviorController {
    Behavior getBehavior(final String line) throws Exception;

    Optional<SimpleATag> conclude() throws Exception;
}
