package xyz.justblink.grace.render.raw;

import xyz.justblink.grace.render.Renderer;
import xyz.justblink.grace.tag.*;
import xyz.justblink.grace.tag.subtag.*;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExportableTagRenderer implements Renderer<ExportableTag> {

    private final ExportableTag exportableDocument;
    private final Visitor visitor;

    private ExportableTagRenderer(Builder builder) {
        this.exportableDocument = builder.exportableDocument;
        this.visitor = new ExportableTagVisitor();
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public ExportableTag render(Tag tag) {
        tag.accept(visitor);
        return exportableDocument;
    }

    public static class Builder {
        private ExportableTag exportableDocument = ExportableTag.create(TagType.DOCUMENT);

        public ExportableTagRenderer build() {
            return new ExportableTagRenderer(this);
        }
    }

    private class ExportableTagVisitor extends AbstractVisitor {

        private Deque<ExportableTag> tagDeque = new ArrayDeque<>();

        @Override
        public void visit(Document document) {
            visitChildren(exportableDocument, document);
        }

        @Override
        public void visit(Code code) {
            visitChildren(ExportableTag.create(TagType.CODE), code);
        }

        @Override
        public void visit(DefaultList defaultList) {
            visitChildren(ExportableTag.create(TagType.UNORDERED_LIST), defaultList);
        }

        @Override
        public void visit(Gist gist) {
            ExportableTag gistExport = ExportableTag.create(TagType.GIST);
            gistExport.set("source", gist.getSource());
            gistExport.set("file", gist.getFile());
            addToParent(gistExport);
        }

        @Override
        public void visit(Header header) {
            ExportableTag headerExport = ExportableTag.create(TagType.HEADER);
            headerExport.set("size", header.getSize());
            headerExport.set("value", header.getValue());
            addToParent(headerExport);
        }

        @Override
        public void visit(Image image) {
            ExportableTag imageExport = ExportableTag.create(TagType.IMAGE);
            imageExport.set("resource", image.getResource());
            imageExport.set("caption", image.getCaption());
            addToParent(imageExport);
        }

        @Override
        public void visit(ItalicText italicText) {
            ExportableTag italicExport = ExportableTag.create(TagType.ITALIC_TEXT);
            italicExport.set("value", italicText.getValue());
            addToParent(italicExport);
        }

        @Override
        public void visit(Link link) {
            ExportableTag linkExport = ExportableTag.create(TagType.LINK);
            linkExport.set("value", link.getValue());
            linkExport.set("url", link.getUrl());
            addToParent(linkExport);
        }

        @Override
        public void visit(Note note) {
            visitChildren(ExportableTag.create(TagType.NOTE), note);
        }

        @Override
        public void visit(OrderedList orderedList) {
            visitChildren(ExportableTag.create(TagType.ORDERED_LIST), orderedList);
        }

        @Override
        public void visit(Paragraph paragraph) {
            visitChildren(ExportableTag.create(TagType.PARAGRAPH), paragraph);
        }

        @Override
        public void visit(StrongText strongText) {
            ExportableTag strongTextExport = ExportableTag.create(TagType.STRONG_TEXT);
            strongTextExport.set("value", strongText.getValue());
            addToParent(strongTextExport);
        }

        @Override
        public void visit(Terminal terminal) {
            visitChildren(ExportableTag.create(TagType.TERMINAL), terminal);
        }

        @Override
        public void visit(Text text) {
            ExportableTag textExport = ExportableTag.create(TagType.TEXT);
            textExport.set("value", text.getValue());
            addToParent(textExport);
        }

        private void visitChildren(ExportableTag exportableTag, Tag tag) {
            pushToDeque(exportableTag);
            visitChildren(tag);
            removeAndAddToParent();
        }

        private void pushToDeque(ExportableTag tag) {
            tagDeque.addFirst(tag);
        }

        private void addToParent(ExportableTag tag) {
            ExportableTag exportableTag = tagDeque.peekFirst();
            if (exportableTag != null)
                exportableTag.addChild(tag);
        }

        private void removeAndAddToParent() {
            ExportableTag exportableTag = tagDeque.pollFirst();
            addToParent(exportableTag);
        }
    }
}
