package xyz.justblink.grace;


import xyz.justblink.grace.tags.BaseTag;

import java.util.Optional;

public interface BehaviorController {
    Behavior getBehavior(final String line) throws Exception;

    Optional<BaseTag> conclude() throws Exception;
}
