package xyz.justblink.grace.internal.builders.subs;


import xyz.justblink.grace.internal.builders.BaseTagBuilder;
import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.subtag.DefaultList;
import xyz.justblink.grace.tag.subtag.Text;

public abstract  class GenericListBuilder extends BaseTagBuilder {

    private DefaultList list;
    private RichTextBuilder builder;
    private Class<? extends DefaultList> type;

    GenericListBuilder(Class<? extends DefaultList> type) {
        this.type = type;
        builder = new RichTextBuilder();
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
            list.addChild(new Text(line));
        else {
            builder.addLine(split[1]);
            list.addChild(builder.build());
            builder.reset();
        }

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
