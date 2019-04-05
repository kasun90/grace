package xyz.justblink.grace.internal.builders;


import xyz.justblink.grace.tags.SimpleATag;

public interface AtagBuilder {
    void addLine(String line);

    SimpleATag build();

    boolean isBuilding();

    void reset();
}
