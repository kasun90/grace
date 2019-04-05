package xyz.justblink.grace.internal.behaviors;


import xyz.justblink.grace.Behavior;
import xyz.justblink.grace.BehaviorModifier;
import xyz.justblink.grace.internal.builders.SimpleATagBuilder;

public class SingleLineBehavior extends BehaviorModifier {

    @Override
    public Behavior action(final String line) {
        this.checkSingleBuilderPresence(this.getClass());

        SimpleATagBuilder builder = builders.get(0);
        builder.addLine(line);
        currentOutput = builder.build();
        builder.reset();
        return this;
    }
}