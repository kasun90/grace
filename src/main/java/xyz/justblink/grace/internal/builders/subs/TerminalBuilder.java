package xyz.justblink.grace.internal.builders.subs;


import xyz.justblink.grace.internal.builders.BaseTagBuilder;
import xyz.justblink.grace.tags.BaseTag;
import xyz.justblink.grace.tags.subtags.Terminal;
import xyz.justblink.grace.tags.subtags.Text;

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
            terminal.addCommand(new Text(split[1]));
    }

    @Override
    public BaseTag build() {
        return terminal;
    }

    @Override
    public boolean isBuilding() {
        return terminal != null && terminal.getCommandsCount() != 0;
    }

    @Override
    public void reset() {
        prompt = null;
        terminal = null;
    }
}
