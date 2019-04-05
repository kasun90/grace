package xyz.justblink.grace.internal.builders;


import xyz.justblink.grace.ATagType;
import xyz.justblink.grace.tags.RichText;
import xyz.justblink.grace.tags.SimpleATag;
import xyz.justblink.grace.tags.Text;

public class RichTextBuilder extends SimpleATagBuilder {

    private RichText richText;
    private StringBuilder builder;
    private boolean strongText = false;

    RichTextBuilder() {
        builder = new StringBuilder();
        richText = new RichText();
    }

    @Override
    public void addLine(String line) {
        for (char c : line.toCharArray()) {
            if (c == '^') {
                if (strongText) {
                    richText.addChild(new Text(ATagType.STRONG_TEXT, builder.toString()));
                    builder.setLength(0);
                    strongText = false;
                } else {
                    if (builder.length() != 0) {
                        richText.addChild(new Text(builder.toString()));
                        builder.setLength(0);
                    }
                    strongText = true;
                }

                continue;
            }
            builder.append(c);
        }
    }

    @Override
    public SimpleATag build() {
        if (builder.length() != 0)
            richText.addChild(new Text(builder.toString()));
        return richText;
    }

    @Override
    public boolean isBuilding() {
        return richText.getChildrenLength() != 0;
    }

    @Override
    public void reset() {
        richText = new RichText();
        builder.setLength(0);
    }
}
