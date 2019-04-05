package xyz.justblink.grace.internal.behaviors;


import xyz.justblink.grace.Behavior;
import xyz.justblink.grace.BehaviorModifier;
import xyz.justblink.grace.internal.builders.SimpleATagBuilder;

public class BoundedBehavior extends BehaviorModifier {

    @Override
    public Behavior action(final String line) throws Exception {
        this.checkSingleBuilderPresence(this.getClass());

        SimpleATagBuilder builder = builders.get(0);

        if (builder.isBuilding()) {
            currentOutput = builder.build();
            builder.reset();
            builderDelegate.restoreDefaultActiveBuilder();
        } else
            builderDelegate.setActiveBuilder(builder);
        return this;
    }
}