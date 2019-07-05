package xyz.justblink.grace.tag.subtag;


import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.Visitor;

import java.util.LinkedList;
import java.util.List;

public class Terminal extends Tag {
    private String prompt;

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getPrompt() {
        return prompt;
    }
}
