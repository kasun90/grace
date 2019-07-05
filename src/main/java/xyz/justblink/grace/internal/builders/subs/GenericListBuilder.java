package xyz.justblink.grace.internal.builders.subs;


import xyz.justblink.grace.internal.builders.InlineTagCapableBuilder;
import xyz.justblink.grace.internal.inline.InlineTagCatcher;
import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.subtag.DefaultList;
import xyz.justblink.grace.tag.subtag.RichText;

public abstract class GenericListBuilder extends InlineTagCapableBuilder implements InlineTagCatcher {

    private DefaultList list;
    private Class<? extends DefaultList> type;
    private RichText currentRichText;

    GenericListBuilder(Class<? extends DefaultList> type) {
        this.type = type;
    }

    @Override
    public void initialize() throws Exception {
        registerCatcher(this);
    }

    @Override
    public void initNewTag() throws Exception {
        super.initNewTag();
        this.list = (DefaultList) type.getDeclaredConstructors()[0].newInstance();
    }

    @Override
    public void addLine(String line) {
        String[] split = line.split("\\s+", 2);
        String listLine = split.length != 2 ? line : split[1];

        this.currentRichText = new RichText();
        feedLine(listLine);
        stopAndEmit().ifPresent(tag -> currentRichText.appendChild(tag));
        list.appendChild(currentRichText);
    }

    @Override
    public void onEmit(Tag tag) {
        currentRichText.appendChild(tag);
    }

    @Override
    public Tag build() {
        return list;
    }

    @Override
    public boolean isBuilding() {
        return list != null;
    }

    @Override
    public void reset() {
        list = null;
        currentRichText = null;
    }
}
