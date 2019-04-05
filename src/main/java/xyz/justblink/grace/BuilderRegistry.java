package xyz.justblink.grace;



import xyz.justblink.grace.internal.GraceRuntimeException;
import xyz.justblink.grace.internal.builders.*;
import xyz.justblink.grace.tags.*;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

final class BuilderRegistry {
    private static Map<Class<? extends SimpleATag>, Class<? extends SimpleATagBuilder>> builderMap = new HashMap<>();

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

    private final Map<Class<? extends SimpleATag>, SimpleATagBuilder> builderCache = new HashMap<>();

    SimpleATagBuilder get(Class<? extends SimpleATag> tag) throws Exception {
        SimpleATagBuilder simpleATagBuilder = builderCache.get(tag);

        if (simpleATagBuilder != null)
            return simpleATagBuilder;

        Class<? extends SimpleATagBuilder> aClass = builderMap.get(tag);
        if (aClass == null)
            throw new GraceRuntimeException(MessageFormat.format("No builder found for this tag: {0}",
                    tag.getName()));
        SimpleATagBuilder newBuilder = createBuilderInstance(aClass);
        builderCache.put(tag, newBuilder);
        return newBuilder;
    }

    private SimpleATagBuilder createBuilderInstance(Class<? extends SimpleATagBuilder> builderClass) throws Exception {
        return (SimpleATagBuilder) Arrays.stream(builderClass.getConstructors())
                .filter(constructor1 -> constructor1.getParameterCount() == 0)
                .findFirst().orElseThrow(() -> new GraceRuntimeException("No valid constructor found")).newInstance();

    }

    final java.util.List<SimpleATagBuilder> get(java.util.List<Class<? extends SimpleATag>> tags) throws Exception {
        java.util.List<SimpleATagBuilder> builders = new ArrayList<>();
        for (Class<? extends SimpleATag> tag : tags) {
            builders.add(get(tag));
        }
        return builders;
    }

}
