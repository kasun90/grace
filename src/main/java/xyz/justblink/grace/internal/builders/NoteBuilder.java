package xyz.justblink.grace.internal.builders;

import xyz.justblink.grace.tags.Note;
import xyz.justblink.grace.tags.SimpleATag;

public class NoteBuilder extends SimpleATagBuilder {

    private StringBuilder builder;

    public NoteBuilder() {
        builder = new StringBuilder();
    }

    @Override
    public void addLine(String line) {
        line = line.trim();

        if (builder.length() != 0)
            builder.append(" ");
        builder.append(line);
    }

    @Override
    public SimpleATag build() {
        return new Note(builder.toString());
    }

    @Override
    public boolean isBuilding() {
        return builder.length() != 0;
    }

    @Override
    public void reset() {
        builder.setLength(0);
    }
}
