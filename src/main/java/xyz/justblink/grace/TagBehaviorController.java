package xyz.justblink.grace;



import xyz.justblink.grace.internal.GraceRuntimeException;
import xyz.justblink.grace.internal.behaviors.GeneralBehavior;
import xyz.justblink.grace.internal.builders.BaseTagBuilder;
import xyz.justblink.grace.tags.subtags.Paragraph;

import java.lang.reflect.Constructor;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

final class TagBehaviorController implements BehaviorController, BuilderDelegate {

    private final Map<Class<? extends Behavior>, Behavior> behaviorCache = new HashMap<>();
    private BaseTagBuilder activeBuilder;
    private BuilderRegistry builderRegistry;
    private BehaviorConfiguration configuration;

    TagBehaviorController(BuilderRegistry builderRegistry, BehaviorConfiguration configuration) throws Exception {
        this.builderRegistry = builderRegistry;
        this.configuration = configuration;
        configuration.initialize();
        restoreDefaultActiveBuilder();
    }

    @Override
    public Behavior getBehavior(final String line) throws Exception {
        Behavior behavior;
        Optional<BehaviorRegistry.BehaviorRegistryEntry> behaviorEntryOptional = configuration.getRegistry().getEntries().
                stream().filter(entry -> entry.getRule().evaluate(line)).findFirst();

        List<Class<? extends SimpleTag>> associatedTags = null;

        if (behaviorEntryOptional.isPresent()) {
            BehaviorRegistry.BehaviorRegistryEntry behaviorRegistryEntry = behaviorEntryOptional.get();
            behavior = createBehavior(behaviorRegistryEntry.getBehaviorClass());
            associatedTags = behaviorRegistryEntry.getAssociatedTags();
        } else
            behavior = createBehavior(GeneralBehavior.class);

        if (behavior instanceof BehaviorModifier) {
            BehaviorModifier behaviorModifier = (BehaviorModifier) behavior;
            behaviorModifier.setBuilderDelegate(this);
            if (associatedTags != null)
                behaviorModifier.setBuilders(builderRegistry.get(associatedTags));
        }

        return behavior;
    }

    private Behavior createBehavior(Class<? extends Behavior> behaviorClass) throws Exception {
        Behavior behavior = behaviorCache.get(behaviorClass);
        if (behavior != null) {
            behavior.startOver();
            return behavior;
        }

        Constructor<?> constructor;

        for (Constructor<?> behaviorClassConstructor : behaviorClass.getConstructors()) {
            if (behaviorClassConstructor.getParameterCount() == 0) {
                constructor = behaviorClassConstructor;
                Behavior newBehaviorInstance = (Behavior) constructor.newInstance();
                behaviorCache.put(behaviorClass, newBehaviorInstance);
                return newBehaviorInstance;
            }
        }

        throw new GraceRuntimeException(MessageFormat.format("Could not create behavior for the class {0} " +
                        "No valid constructor found",
                behaviorClass.getName()));
    }

    @Override
    public Optional<SimpleTag> conclude() throws Exception {
        Behavior behavior = getBehavior(BehaviorConfiguration.BREAK_LINE);
        return behavior.action(BehaviorConfiguration.BREAK_LINE).output();
    }

    @Override
    public BaseTagBuilder getActiveBuilder() {
        if (activeBuilder == null)
            throw new GraceRuntimeException("No active builder found. There must be an active builder");
        return activeBuilder;
    }

    @Override
    public void setActiveBuilder(BaseTagBuilder builder) {
        this.activeBuilder = builder;
    }

    @Override
    public void restoreDefaultActiveBuilder() throws Exception {
        this.activeBuilder = builderRegistry.get(Paragraph.class);
    }
}
