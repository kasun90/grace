package xyz.justblink.grace.tag;

import xyz.justblink.grace.tag.subtag.*;

public interface Visitor {

    void visit(Document document);

    void visit(Code code);

    void visit(DefaultList defaultList);

    void visit(Gist gist);

    void visit(Header header);

    void visit(Image image);

    void visit(ItalicText italicText);

    void visit(Link link);

    void visit(Note note);

    void visit(OrderedList orderedList);

    void visit(Paragraph paragraph);

    void visit(StrongText strongText);

    void visit(Terminal terminal);

    void visit(Text text);

    void visit(RichText richText);

}
