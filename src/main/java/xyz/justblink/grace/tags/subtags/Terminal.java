package xyz.justblink.grace.tags.subtags;


import xyz.justblink.grace.TagType;
import xyz.justblink.grace.tags.BaseTag;

import java.util.LinkedList;
import java.util.List;

public class Terminal extends BaseTag {

    private List<BaseTag> commands;
    private String prompt;

    public Terminal() {
        super(TagType.TERMINAL);
        commands = new LinkedList<>();
    }

    public void addCommand(BaseTag command) {
        commands.add(command);
    }

    public int getCommandsCount() {
        return commands.size();
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
