package xyz.justblink.grace;


import xyz.justblink.grace.internal.behaviors.BoundedBehavior;
import xyz.justblink.grace.internal.behaviors.BreakTagBehavior;
import xyz.justblink.grace.internal.behaviors.SingleLineBehavior;
import xyz.justblink.grace.internal.behaviors.SpecialStatefulBehavior;
import xyz.justblink.grace.tag.subtag.*;

final class BehaviorConfiguration {
    static final String BREAK_LINE = "[BREAK]";
    private BehaviorRegistry registry;

    BehaviorConfiguration(BehaviorRegistry registry) {
        this.registry = registry;
    }

    BehaviorRegistry getRegistry() {
        return registry;
    }

    void initialize() {
        registry.register(line -> line.startsWith("#"), SingleLineBehavior.class, Header.class);
        registry.register(line -> line.isEmpty() || line.startsWith(BREAK_LINE),
                BreakTagBehavior.class, DefaultList.class, OrderedList.class, Paragraph.class);
        registry.register(line -> line.startsWith("!!"), BoundedBehavior.class, Note.class);
        registry.register(line -> line.startsWith("!("), SingleLineBehavior.class, Image.class);
        registry.register(line -> line.startsWith("**"), SpecialStatefulBehavior.class, DefaultList.class);
        registry.register(line -> line.startsWith("*@"), SpecialStatefulBehavior.class, OrderedList.class);
        registry.register(line -> line.startsWith("```"), BoundedBehavior.class, Terminal.class);
        registry.register(line -> line.startsWith("``"), BoundedBehavior.class, Code.class);
        registry.register(line -> line.startsWith("[gist]"), SingleLineBehavior.class, Gist.class);
    }
}
