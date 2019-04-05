package xyz.justblink.grace.internal.builders;

import com.blink.atag.tags.SimpleATag;

public interface AtagBuilder {
    void addLine(String line);
    SimpleATag build();
    boolean isBuilding();
    void reset();
}
