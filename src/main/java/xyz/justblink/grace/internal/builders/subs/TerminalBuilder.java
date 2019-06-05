package xyz.justblink.grace.internal.builders.subs;


import xyz.justblink.grace.internal.builders.BaseTagBuilder;
import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.subtag.Terminal;
import xyz.justblink.grace.tag.subtag.Text;

public class TerminalBuilder extends BaseTagBuilder {

    private Terminal terminal;
    private String prompt;

    @Override
    public void addLine(String line) {
        if (terminal == null)
            terminal = new Terminal();
        String[] split = line.split("\\s+", 2);
        if (prompt == null) {
            prompt = split[0];
            terminal.setPrompt(prompt);
        }

        if (split.length == 2)
            terminal.appendChild(new Text(split[1]));
    }

    @Override
    public Tag build() {
        return terminal;
    }

    @Override
    public boolean isBuilding() {
        return terminal != null && terminal.hasChildren();
    }

    @Override
    public void reset() {
        prompt = null;
        terminal = null;
    }
}
