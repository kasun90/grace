package xyz.justblink.grace;

import xyz.justblink.grace.internal.GraceRuntimeException;
import xyz.justblink.grace.tag.Document;

import java.io.*;

public final class Processor {

    public static Document process(final File file) throws Exception {
        final FileInputStream fileInputStream = new FileInputStream(file);
        Document document = process(fileInputStream, "UTF-8");
        fileInputStream.close();
        return document;
    }

    public static Document process(final File file, String encoding) throws Exception {
        final FileInputStream fileInputStream = new FileInputStream(file);
        Document document = process(fileInputStream, encoding);
        fileInputStream.close();
        return document;
    }

    public static Document process(final String rawText) {
        return process(new BufferedReader(new StringReader(rawText)));
    }

    public static Document process(final InputStream inputStream, String encoding) throws Exception {
        return process(new BufferedReader(new InputStreamReader(inputStream, encoding)));
    }

    public static Document process(final Reader reader) {
        BufferedReader bufferedReader = !(reader instanceof BufferedReader) ? new BufferedReader(reader)
                : (BufferedReader) reader;

        final Document document = new Document();

        try {
            final BehaviorController controller = new TagBehaviorController(new BuilderRegistry(), new BehaviorConfiguration(
                    new BehaviorRegistry()
            ));

            bufferedReader.lines().forEach(line -> {
                try {
                    Behavior behavior = controller.getBehavior(line);
                    behavior.action(line).output().ifPresent(document::appendChild);
                } catch (Exception e) {
                    throw new GraceRuntimeException(e);
                }
            });

            bufferedReader.close();

            controller.conclude().ifPresent(document::appendChild);
        } catch (Exception e) {
            throw new GraceRuntimeException(e);
        }
        return document;
    }
}
