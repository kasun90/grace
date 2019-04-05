package xyz.justblink.grace;


import xyz.justblink.grace.internal.builders.SimpleATagBuilder;

public interface BuilderDelegate {
    void restoreDefaultActiveBuilder() throws Exception;

    SimpleATagBuilder getActiveBuilder();

    void setActiveBuilder(SimpleATagBuilder builder);
}
