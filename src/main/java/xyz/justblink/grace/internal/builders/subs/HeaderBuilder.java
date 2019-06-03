package xyz.justblink.grace.internal.builders.subs;


import xyz.justblink.grace.internal.builders.BaseTagBuilder;
import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.subtag.Header;

public class HeaderBuilder extends BaseTagBuilder {

    private Header header;

    @Override
    public void addLine(String line) {
        String[] split = line.split("\\s+", 2);

        if (split.length != 2) {
            header = new Header(line, 1);
            return;
        }
        header = new Header(split[1], split[0].length());
    }

    @Override
    public Tag build() {
        return header;
    }

    @Override
    public boolean isBuilding() {
        return header != null;
    }

    @Override
    public void reset() {
        header = null;
    }
}
