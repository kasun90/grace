package xyz.justblink.grace;



import xyz.justblink.grace.internal.GraceRuntimeException;
import xyz.justblink.grace.internal.builders.*;
import xyz.justblink.grace.internal.builders.subs.*;
import xyz.justblink.grace.tags.subtags.*;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

final class BuilderRegistry {
    private static Map<Class<? extends SimpleTag>, Class<? extends BaseTagBuilder>> builderMap = new HashMap<>();

    static {
        builderMap.put(Code.class, CodeBuilder.class);
        builderMap.put(Gist.class, GistBuilder.class);
        builderMap.put(Header.class, HeaderBuilder.class);
        builderMap.put(Image.class, ImageBuilder.class);
        builderMap.put(DefaultList.class, UnorderedListBuilder.class);
        builderMap.put(Note.class, NoteBuilder.class);
        builderMap.put(OrderedList.class, OrderedListBuilder.class);
        builderMap.put(Paragraph.class, ParagraphBuilder.class);
        builderMap.put(RichText.class, RichTextBuilder.class);
        builderMap.put(Terminal.class, TerminalBuilder.class);
    }

    private final Map<Class<? extends SimpleTag>, BaseTagBuilder> builderCache = new HashMap<>();

    BaseTagBuilder get(Class<? extends SimpleTag> tag) throws Exception {
        BaseTagBuilder simpleATagBuilder = builderCache.get(tag);

        if (simpleATagBuilder != null)
            return simpleATagBuilder;

        Class<? extends BaseTagBuilder> aClass = builderMap.get(tag);
        if (aClass == null)
            throw new GraceRuntimeException(MessageFormat.format("No builder found for this tag: {0}",
                    tag.getName()));
        BaseTagBuilder newBuilder = createBuilderInstance(aClass);
        builderCache.put(tag, newBuilder);
        return newBuilder;
    }

    private BaseTagBuilder createBuilderInstance(Class<? extends BaseTagBuilder> builderClass) throws Exception {
        return (BaseTagBuilder) Arrays.stream(builderClass.getConstructors())
                .filter(constructor1 -> constructor1.getParameterCount() == 0)
                .findFirst().orElseThrow(() -> new GraceRuntimeException("No valid constructor found")).newInstance();

    }

    final java.util.List<BaseTagBuilder> get(java.util.List<Class<? extends SimpleTag>> tags) throws Exception {
        java.util.List<BaseTagBuilder> builders = new ArrayList<>();
        for (Class<? extends SimpleTag> tag : tags) {
            builders.add(get(tag));
        }
        return builders;
    }

}
