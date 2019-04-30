package xyz.justblink.grace.internal.builders.subs;

import xyz.justblink.grace.internal.builders.BaseTagBuilder;
import xyz.justblink.grace.tags.BaseTag;
import xyz.justblink.grace.tags.subtags.Note;

public class NoteBuilder extends BaseTagBuilder {

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
    public BaseTag build() {
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
