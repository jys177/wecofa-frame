package wecofa.frame.batch.chunk.reader.lineHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.LineCallbackHandler;

public class DefaultHeaderLineHandler implements LineCallbackHandler {

    private static final Logger logger = LoggerFactory.getLogger(DefaultHeaderLineHandler.class);

    // Header Line Mapper

    @Override
    public void handleLine(String s) {

    }


}
