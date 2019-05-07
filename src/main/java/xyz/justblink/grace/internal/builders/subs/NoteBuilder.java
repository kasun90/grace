package xyz.justblink.grace.internal.builders.subs;

import xyz.justblink.grace.internal.builders.InlineTagCapableBuilder;
import xyz.justblink.grace.internal.inline.InlineTagCatcher;
import xyz.justblink.grace.tags.BaseTag;
import xyz.justblink.grace.tags.subtags.Note;

public class NoteBuilder extends InlineTagCapableBuilder implements InlineTagCatcher {

    private Note note = new Note();

    @Override
    public void addLine(String line) {
        feedLine(line);
    }

    @Override
    public void initialize() throws Exception {
        registerCatcher(this);
    }

    @Override
    public void onEmit(BaseTag tag) {
        note.addChild(tag);
    }

    @Override
    public BaseTag build() {
        stopAndEmit().ifPresent(tag -> note.addChild(tag));
        return note;
    }

    @Override
    public boolean isBuilding() {
        return note.getChildrenLength() != 0 || hasCache();
    }

    @Override
    public void reset() {
        note = new Note();
    }
}
