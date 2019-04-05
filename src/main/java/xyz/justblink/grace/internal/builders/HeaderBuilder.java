package xyz.justblink.grace.internal.builders;


import xyz.justblink.grace.tags.Header;
import xyz.justblink.grace.tags.SimpleATag;

public class HeaderBuilder extends SimpleATagBuilder {

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
    public SimpleATag build() {
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
