package xyz.justblink.grace.internal.builders;


import xyz.justblink.grace.tags.DefaultList;
import xyz.justblink.grace.tags.SimpleATag;
import xyz.justblink.grace.tags.Text;

public abstract  class GenericListBuilder extends SimpleATagBuilder {

    private DefaultList list;
    private RichTextBuilder builder;
    private Class<? extends DefaultList> type;

    GenericListBuilder(Class<? extends DefaultList> type) {
        this.type = type;
        builder = new RichTextBuilder();
    }

    @Override
    public void initNew() throws Exception {
        super.initNew();
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
    public SimpleATag build() {
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
