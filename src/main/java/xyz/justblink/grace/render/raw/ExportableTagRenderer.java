package xyz.justblink.grace.render.raw;

import xyz.justblink.grace.render.Renderer;
import xyz.justblink.grace.tag.AbstractVisitor;
import xyz.justblink.grace.tag.Document;
import xyz.justblink.grace.tag.Tag;
import xyz.justblink.grace.tag.subtag.*;

import java.util.LinkedList;
import java.util.List;

public class ExportableTagRenderer extends AbstractVisitor implements Renderer<List<ExportableTag>> {

    private List<ExportableTag> exportableTags = new LinkedList<>();

    @Override
    public List<ExportableTag> render(Tag tag) {
        tag.accept(this);
        return exportableTags;
    }

    @Override
    public void visit(Document document) {
        visitChildren(document);
    }

    @Override
    public void visit(Code code) {

    }

    @Override
    public void visit(DefaultList defaultList) {

    }

    @Override
    public void visit(Gist gist) {

    }

    @Override
    public void visit(Header header) {

    }

    @Override
    public void visit(Image image) {

    }

    @Override
    public void visit(ItalicText italicText) {

    }

    @Override
    public void visit(Link link) {

    }

    @Override
    public void visit(Note note) {

    }

    @Override
    public void visit(OrderedList orderedList) {

    }

    @Override
    public void visit(Paragraph paragraph) {

    }

    @Override
    public void visit(StrongText strongText) {

    }

    @Override
    public void visit(Terminal terminal) {

    }

    @Override
    public void visit(Text text) {

    }
}
