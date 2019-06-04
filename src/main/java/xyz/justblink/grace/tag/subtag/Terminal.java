package xyz.justblink.grace.tag.subtag;


import xyz.justblink.grace.tag.Tag;

import java.util.LinkedList;
import java.util.List;

public class Terminal extends Tag {

    private List<Tag> commands;
    private String prompt;

    public Terminal() {
        commands = new LinkedList<>();
    }

    public void addCommand(Tag command) {
        commands.add(command);
    }

    public int getCommandsCount() {
        return commands.size();
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
