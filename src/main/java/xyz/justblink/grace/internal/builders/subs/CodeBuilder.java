package xyz.justblink.grace.internal.builders.subs;

import xyz.justblink.grace.internal.builders.BaseTagBuilder;
import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.subtag.Code;
import xyz.justblink.grace.tag.subtag.Text;

public class CodeBuilder extends BaseTagBuilder {

    private Code code;

    @Override
    public void addLine(String line) {
        if (code == null)
            code = new Code();
        code.addLine(new Text(line));
    }

    @Override
    public Tag build() {
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
