package xyz.justblink.grace.internal.builders;


import xyz.justblink.grace.ATagType;
import xyz.justblink.grace.tags.Link;
import xyz.justblink.grace.tags.Paragraph;
import xyz.justblink.grace.tags.SimpleATag;
import xyz.justblink.grace.tags.Text;

public class ParagraphBuilder extends SimpleATagBuilder {

    private StringBuilder builder;
    private Paragraph paragraph;
    private boolean expectLink = false;
    private boolean strongText = false;
    private String currentLink = null;

    public ParagraphBuilder() {
        builder = new StringBuilder();
        paragraph = new Paragraph();
    }

    @Override
    public void addLine(String line) {
        for (char c : line.toCharArray()) {
            if (c == '[') {
                if (builder.length() != 0) {
                    paragraph.addChild(new Text(builder.toString()));
                    builder.setLength(0);
                }
                continue;
            } else if (c == ']') {
                currentLink = builder.toString();
                builder.setLength(0);
                expectLink = true;
                continue;
            } else if (expectLink) {
                if (c == '(') {
                    continue;
                } else if (c == ')') {
                    String currentURL = builder.toString();
                    builder.setLength(0);
                    paragraph.addChild(new Link(currentLink, currentURL));
                    expectLink = false;
                    currentLink = null;
                    continue;
                }
            } else if (c == '^') {
                if (strongText) {
                    paragraph.addChild(new Text(ATagType.STRONG_TEXT, builder.toString()));
                    builder.setLength(0);
                    strongText = false;
                } else {
                    if (builder.length() != 0) {
                        paragraph.addChild(new Text(builder.toString()));
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
            paragraph.addChild(new Text(builder.toString()));
        return paragraph;
    }

    @Override
    public boolean isBuilding() {
        return paragraph.getChildrenLength() != 0 || builder.length() != 0;
    }

    @Override
    public void reset() {
        paragraph = new Paragraph();
        builder.setLength(0);
    }
}
