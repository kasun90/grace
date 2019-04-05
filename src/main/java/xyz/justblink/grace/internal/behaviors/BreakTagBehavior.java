package xyz.justblink.grace.internal.behaviors;

import xyz.justblink.grace.Behavior;
import xyz.justblink.grace.BehaviorModifier;
import xyz.justblink.grace.internal.builders.SimpleATagBuilder;

public class BreakTagBehavior extends BehaviorModifier {
    @Override
    public Behavior action(final String line) {
        for (SimpleATagBuilder builder : builders) {
            if (builder.isBuilding()) {
                currentOutput = builder.build();
                builder.reset();
                break;
            }
        }
        return this;
    }
}