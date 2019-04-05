package xyz.justblink.grace.internal.builders;

import xyz.justblink.grace.tags.Code;
import xyz.justblink.grace.tags.SimpleATag;
import xyz.justblink.grace.tags.Text;

public class CodeBuilder extends SimpleATagBuilder {

    private Code code;

    @Override
    public void addLine(String line) {
        if (code == null)
            code = new Code();
        code.addLine(new Text(line));
    }

    @Override
    public SimpleATag build() {
        return code;
    }

    @Override
    public boolean isBuilding() {
        return code != null && code.getLineCount() != 0;
    }

    @Override
    public void reset() {
        code = null;
    }
}
