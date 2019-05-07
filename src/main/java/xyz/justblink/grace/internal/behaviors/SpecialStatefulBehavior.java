package xyz.justblink.grace.internal.behaviors;

import xyz.justblink.grace.Behavior;
import xyz.justblink.grace.BehaviorModifier;
import xyz.justblink.grace.internal.builders.BaseTagBuilder;

public class SpecialStatefulBehavior extends BehaviorModifier {

    @Override
    public Behavior action(final String line) throws Exception {
        this.checkSingleBuilderPresence(this.getClass());

        BaseTagBuilder builder = builders.get(0);

        if (!builder.isBuilding())
            builder.initNewTag();
        builder.addLine(line);
        return this;
    }
}