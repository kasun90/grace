package xyz.justblink.grace.tags.subtags;


import xyz.justblink.grace.TagType;
import xyz.justblink.grace.tags.BaseTag;

import java.util.LinkedList;
import java.util.List;

public class Code extends BaseTag {

    private List<Text> lines;

    public Code() {
        this(new LinkedList<>());
    }

    public Code(List<Text> lines) {
        super(TagType.CODE);
        this.lines = lines;
    }

    public void addLine(Text command) {
        this.lines.add(command);
    }

    public int getLineCount() {
        return this.lines.size();
    }

}
