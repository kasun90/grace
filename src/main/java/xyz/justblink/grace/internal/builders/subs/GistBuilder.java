package xyz.justblink.grace.internal.builders.subs;


import xyz.justblink.grace.internal.builders.BaseTagBuilder;
import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.subtag.Gist;

public class GistBuilder extends BaseTagBuilder {

    private String source;
    private String file;

    @Override
    public void addLine(String line) {
        StringBuilder builder = new StringBuilder();
        line = line.replaceAll("\\[gist]", "");
        for (char c : line.toCharArray()) {
            if (c == '(' || c == '[' || c == '!')
                continue;
            else if (c == ')') {
                source = builder.toString();
                builder.setLength(0);
                continue;
            } else if (c == ']') {
                file = builder.toString();
                builder.setLength(0);
                continue;
            }
            builder.append(c);
        }
    }

    @Override
    public Tag build() {
        return new Gist(source, file);
    }

    @Override
    public boolean isBuilding() {
        return source != null;
    }

    @Override
    public void reset() {
        source = null;
    }
}
