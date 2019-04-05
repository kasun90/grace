package xyz.justblink.grace.internal.behaviors;

import xyz.justblink.grace.Behavior;
import xyz.justblink.grace.BehaviorModifier;

public class GeneralBehavior extends BehaviorModifier {

    @Override
    public Behavior action(final String line) {
        builderDelegate.getActiveBuilder().addLine(line);
        return this;
    }
}