package xyz.justblink.grace.internal.builders;


import xyz.justblink.grace.tags.BaseTag;

public interface TagBuilder {
    void addLine(String line);

    BaseTag build();

    boolean isBuilding();

    void reset();
}
