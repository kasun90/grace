package xyz.justblink.grace.internal.inline.rich;

import xyz.justblink.grace.internal.inline.InlineTagCatcher;
import xyz.justblink.grace.internal.inline.InlineTagEmitter;
import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.subtag.Link;
import xyz.justblink.grace.tag.subtag.StrongText;
import xyz.justblink.grace.tag.subtag.Text;

import java.util.Optional;

public class RichInlineTagEmitter implements InlineTagEmitter {

    private StringBuilder builder = new StringBuilder();
    private InlineTagCatcher catcher;
    private boolean expectLink = false;
    private boolean strongText = false;
    private String currentLink = null;

    @Override
    public void feedLine(String line) {
        for (char c : line.toCharArray()) {
            if (c == '[') {
                if (builder.length() != 0) {
                    emit(new Text(builder.toString()));
                    builder.setLength(0);
                }
                continue;
            } else if (c == ']') {
                currentLink = builder.toString();
                builder.setLength(0);
                expectLink = true;
                continue;
            } else if (expectLink) {
                if (c == '(') {
                    continue;
                } else if (c == ')') {
                    String currentURL = builder.toString();
                    builder.setLength(0);
                    emit(new Link(currentLink, currentURL));
                    expectLink = false;
                    currentLink = null;
                    continue;
                }
            } else if (c == '^') {
                if (strongText) {
                    emit(new StrongText(builder.toString()));
                    builder.setLength(0);
                    strongText = false;
                } else {
                    if (builder.length() != 0) {
                        emit(new Text(builder.toString()));
                        builder.setLength(0);
                    }
                    strongText = true;
                }

                continue;
            }
            builder.append(c);
        }
    }

    private void emit(Tag tag) {
        if (catcher != null)
            catcher.onEmit(tag);
    }

    @Override
    public void registerCatcher(InlineTagCatcher catcher) {
        this.catcher = catcher;
    }

    @Override
    public Optional<Tag> stopAndEmit() {
        if (builder.length() != 0) {
            String text = builder.toString();
            builder.setLength(0);
            return Optional.of(new Text(text));
        } else
            return Optional.empty();
    }

    @Override
    public boolean hasCache() {
        return builder.length() != 0;
    }
}
