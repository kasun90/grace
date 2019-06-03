package xyz.justblink.grace;


import xyz.justblink.grace.tag.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class BehaviorRegistry {

    private final List<BehaviorRegistryEntry> entries = new ArrayList<>();

    @SafeVarargs
    final void register(Rule rule, Class<? extends Behavior> behaviorClass, Class<? extends Tag>... tags) {
        entries.add(new BehaviorRegistryEntry(rule, behaviorClass, tags));
    }

    List<BehaviorRegistryEntry> getEntries() {
        return entries;
    }

    class BehaviorRegistryEntry {
        private Rule rule;
        private Class<? extends Behavior> behaviorClass;
        private List<Class<? extends Tag>> associatedTags;

        @SafeVarargs
        BehaviorRegistryEntry(Rule rule, Class<? extends Behavior> behaviorClass, Class<? extends Tag>... tags) {
            this.rule = rule;
            this.behaviorClass = behaviorClass;
            this.associatedTags = Arrays.asList(tags);
        }

        Rule getRule() {
            return rule;
        }

        Class<? extends Behavior> getBehaviorClass() {
            return behaviorClass;
        }

        List<Class<? extends Tag>> getAssociatedTags() {
            return associatedTags;
        }
    }
}
