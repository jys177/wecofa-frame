package wecofa.frame.batch.chunk.writer.callback;

import org.springframework.batch.item.file.FlatFileFooterCallback;

import java.io.IOException;
import java.io.Writer;

public class DefaultFooterCallback implements FlatFileFooterCallback {
    private String insertToFooter;

    private FooterStruct footerStruct;

    @Override
    public void writeFooter(Writer writer) throws IOException {
        writer.write(insertToFooter);
    }

    public void setInsertToFooter(String insertToFooter) {
        this.insertToFooter = insertToFooter;
    }
}
