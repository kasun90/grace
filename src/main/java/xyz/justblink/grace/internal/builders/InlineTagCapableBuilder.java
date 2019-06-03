package xyz.justblink.grace.internal.builders;

import xyz.justblink.grace.internal.GraceRuntimeException;
import xyz.justblink.grace.internal.inline.InlineTagCatcher;
import xyz.justblink.grace.internal.inline.InlineTagEmitter;
import xyz.justblink.grace.tag.Tag;

import java.text.MessageFormat;
import java.util.Optional;

public abstract class InlineTagCapableBuilder extends BaseTagBuilder {

    private InlineTagEmitter emitter;

    public void setEmitter(InlineTagEmitter emitter) {
        this.emitter = emitter;
    }

    protected void feedLine(String line) {
        if (emitter != null)
            emitter.feedLine(line);

    }

    protected void registerCatcher(InlineTagCatcher catcher) {
        checkEmitterConfigurability();
        emitter.registerCatcher(catcher);
    }

    private void checkEmitterConfigurability() {
        if (emitter == null)
            throw new GraceRuntimeException(MessageFormat.format("{0} is not configured to process inline tag" +
                            " or you have tried to use in the constructor",
                    this.getClass().getSimpleName()));
    }

    protected Optional<Tag> stopAndEmit() {
        return emitter.stopAndEmit();
    }

    protected boolean hasCache() {
        return emitter.hasCache();
    }
}
