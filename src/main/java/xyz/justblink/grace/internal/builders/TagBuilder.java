package xyz.justblink.grace.internal.builders;


import xyz.justblink.grace.tag.Tag;

public interface TagBuilder {
    void addLine(String line);

    Tag build();

    boolean isBuilding();

    void reset();
}
