package xyz.justblink.grace.internal.builders.subs;


import xyz.justblink.grace.TagType;
import xyz.justblink.grace.internal.builders.BaseTagBuilder;
import xyz.justblink.grace.tags.BaseTag;
import xyz.justblink.grace.tags.subtags.RichText;
import xyz.justblink.grace.tags.subtags.Text;

public class RichTextBuilder extends BaseTagBuilder {

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
                    richText.addChild(new Text(TagType.STRONG_TEXT, builder.toString()));
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
    public BaseTag build() {
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
