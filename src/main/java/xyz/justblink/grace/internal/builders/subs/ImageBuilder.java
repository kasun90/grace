package xyz.justblink.grace.internal.builders.subs;


import xyz.justblink.grace.internal.builders.BaseTagBuilder;
import xyz.justblink.grace.tags.BaseTag;
import xyz.justblink.grace.tags.subtags.Image;

public class ImageBuilder extends BaseTagBuilder {

    private String resource;
    private String caption = "No Caption";

    @Override
    public void addLine(String line) {
        StringBuilder builder = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (c == '(' || c == '[' || c == '!')
                continue;
            else if (c == ')') {
                resource = builder.toString();
                builder.setLength(0);
                continue;
            } else if (c == ']') {
                caption = builder.toString();
                builder.setLength(0);
                continue;
            }
            builder.append(c);
        }
    }

    @Override
    public BaseTag build() {
        return new Image(resource, caption);
    }

    @Override
    public boolean isBuilding() {
        return resource != null;
    }

    @Override
    public void reset() {
        resource = null;
        caption = null;
    }
}
