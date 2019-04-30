package xyz.justblink.grace;


import xyz.justblink.grace.internal.builders.BaseTagBuilder;

public interface BuilderDelegate {
    void restoreDefaultActiveBuilder() throws Exception;

    BaseTagBuilder getActiveBuilder();

    void setActiveBuilder(BaseTagBuilder builder);
}
