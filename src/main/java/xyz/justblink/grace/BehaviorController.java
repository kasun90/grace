package xyz.justblink.grace;


import java.util.Optional;

public interface BehaviorController {
    Behavior getBehavior(final String line) throws Exception;

    Optional<SimpleTag> conclude() throws Exception;
}
