package xyz.justblink.grace.internal.builders.subs;

import xyz.justblink.grace.internal.builders.BaseTagBuilder;
import xyz.justblink.grace.tags.BaseTag;
import xyz.justblink.grace.tags.subtags.Code;
import xyz.justblink.grace.tags.subtags.Text;

public class CodeBuilder extends BaseTagBuilder {

    private Code code;

    @Override
    public void addLine(String line) {
        if (code == null)
            code = new Code();
        code.addLine(new Text(line));
    }

    @Override
    public BaseTag build() {
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
