package xyz.justblink.grace.internal.behaviors;

import com.blink.atag.Behavior;
import com.blink.atag.BehaviorModifier;

public class GeneralBehavior extends BehaviorModifier {

    @Override
    public Behavior action(final String line) {
        builderDelegate.getActiveBuilder().addLine(line);
        return this;
    }
}