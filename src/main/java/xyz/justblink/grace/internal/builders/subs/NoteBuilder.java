package xyz.justblink.grace.internal.builders.subs;

import xyz.justblink.grace.internal.builders.InlineTagCapableBuilder;
import xyz.justblink.grace.internal.inline.InlineTagCatcher;
import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.subtag.Note;

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
    public void onEmit(Tag tag) {
        note.addChild(tag);
    }

    @Override
    public Tag build() {
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
