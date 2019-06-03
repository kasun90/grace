package xyz.justblink.grace.internal.builders.subs;


import xyz.justblink.grace.internal.builders.InlineTagCapableBuilder;
import xyz.justblink.grace.internal.inline.InlineTagCatcher;
import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.subtag.Paragraph;

public class ParagraphBuilder extends InlineTagCapableBuilder implements InlineTagCatcher {

    private Paragraph paragraph;

    public ParagraphBuilder() {
        paragraph = new Paragraph();
    }

    @Override
    public void initialize() throws Exception {
        registerCatcher(this);
    }

    @Override
    public void addLine(String line) {
        feedLine(line);
    }

    @Override
    public void onEmit(Tag tag) {
        paragraph.addChild(tag);
    }

    @Override
    public Tag build() {
        stopAndEmit().ifPresent(tag -> paragraph.addChild(tag));
        return paragraph;
    }

    @Override
    public boolean isBuilding() {
        return paragraph.getChildrenLength() != 0 || hasCache();
    }

    @Override
    public void reset() {
        paragraph = new Paragraph();
    }
}
