package wecofa.frame.batch.chunk.reader;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ReaderNotOpenException;
import org.springframework.batch.item.file.*;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;


/**
 *
 * 일반적인 FlatFileReader 이면서 Header와 Trailer 구조를 가질 때에도 사용 가능한 Reader
 * header 는 문서의 앞 부분에서 문서의 정보를 담고 있는 영역을 말한다.
 * trailer 는 문서의 뒷 부분에서 문서의 정보를 담고 있는 영역을 말한다.
 * **/
public class WecofaFlatFileItemReader<T> extends AbstractItemCountingItemStreamItemReader implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(WecofaFlatFileItemReader.class);

    public static final String[] DEFAULT_COMMENT_PREFIXES = new String[]{"#"};
    public static final String DEFAULT_CHARSET = Charset.defaultCharset().name();
    protected String[] comments;
    private boolean strict;
    private BufferedReader reader;
    private Resource resource;
    private String encoding=DEFAULT_CHARSET;
    private int dataLineCount;
    private int skipHeaderLines=0;
    private LineCallbackHandler skipHeaderHandler;
    private LineCallbackHandler skipFooterHandler;
    private boolean noInput;
    private int lineCount = 0;
    private LineMapper<T> lineMapper;
    private BufferedReaderFactory bufferedReaderFactory;

    public void setComments(String[] comments) {
        this.comments = new String[comments.length];
        System.arraycopy(comments, 0, this.comments, 0, comments.length);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    protected boolean isComment(String line) {
        String[] var2 = this.comments;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String prefix = var2[var4];
            if (line.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected Object doRead() throws Exception {
        if (this.noInput) {
            return null;
        } else {
            String line = this.readLine();
            if (line == null) {
                return null;
            } else {
                try {
                    if(skipFooterHandler==null){
                        return this.lineMapper.mapLine(line, this.lineCount);
                    }else{
                        //lineCount < dataLineCount
                        if(this.lineCount<dataLineCount){
                            return this.lineMapper.mapLine(line, this.lineCount);
                        }else{
                            //else parsing trailer (lineCount >= dataLineCount)
                            this.skipFooterHandler.handleLine(line);
                            return null;
                        }
                    }
                } catch (Exception var3) {
                    throw new FlatFileParseException("Parsing error at line: " + this.lineCount + " in resource=[" + this.resource.getDescription() + "], input=[" + line + "]", var3, line, this.lineCount);
                }
            }
        }
    }
    @Nullable
    private String readLine() {
        if (this.reader == null) {
            throw new ReaderNotOpenException("Reader must be open before it can be read.");
        } else {
            String line = null;

            try {
                line = this.reader.readLine();
                if (line == null) {
                    return null;
                } else {
                    ++this.lineCount;

                    while(this.isComment(line)) {
                        line = this.reader.readLine();
                        if (line == null) {
                            return null;
                        }
                        ++this.lineCount;
                    }

                    return line;
                }
            } catch (IOException var3) {
                this.noInput = true;
                throw new NonTransientFlatFileException("Unable to read from resource: [" + this.resource + "]", var3, line, this.lineCount);
            }
        }
    }

    @Override
    protected void doOpen() throws Exception {
        //header line parsing
        Assert.notNull(this.resource, "Input resource must be set");
        this.noInput = true;
        if (!this.resource.exists()) {
            if (this.strict) {
                throw new IllegalStateException("Input resource must exist (reader is in 'strict' mode): " + this.resource);
            } else {
                logger.warn("Input resource does not exist " + this.resource.getDescription());
            }
        } else if (!this.resource.isReadable()) {
            if (this.strict) {
                throw new IllegalStateException("Input resource must be readable (reader is in 'strict' mode): " + this.resource);
            } else {
                logger.warn("Input resource is not readable " + this.resource.getDescription());
            }
        } else {
            this.reader = this.bufferedReaderFactory.create(this.resource, this.encoding);

            for(int i = 0; i < this.skipHeaderLines; ++i) {
                String line = this.readLine();
                if (this.skipHeaderHandler != null) {
                    this.skipHeaderHandler.handleLine(line);
                }
            }

            this.noInput = false;
        }
    }

    @Override
    protected void doClose() throws Exception {
        this.lineCount = 0;
        if (this.reader != null) {
            this.reader.close();
        }

    }
}
