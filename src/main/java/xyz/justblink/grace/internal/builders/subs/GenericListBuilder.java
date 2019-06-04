package xyz.justblink.grace.internal.builders.subs;


import xyz.justblink.grace.internal.builders.InlineTagCapableBuilder;
import xyz.justblink.grace.internal.inline.InlineTagCatcher;
import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.subtag.DefaultList;
import xyz.justblink.grace.tag.subtag.Text;

public abstract class GenericListBuilder extends InlineTagCapableBuilder implements InlineTagCatcher {

    private DefaultList list;
    private Class<? extends DefaultList> type;

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
        if (split.length != 2)
            list.appendChild(new Text(line));
        else {
            feedLine(split[1]);
            stopAndEmit().ifPresent(tag -> list.appendChild(tag));
        }

    }

    @Override
    public void onEmit(Tag tag) {
        list.appendChild(tag);
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
    }
}
