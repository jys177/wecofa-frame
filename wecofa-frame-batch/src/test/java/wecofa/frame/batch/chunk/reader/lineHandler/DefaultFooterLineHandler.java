package wecofa.frame.batch.chunk.reader.lineHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.LineCallbackHandler;
import org.springframework.batch.item.file.LineMapper;

public class DefaultFooterLineHandler implements LineCallbackHandler {

    private static final Logger logger = LoggerFactory.getLogger(DefaultFooterLineHandler.class);

    // Trailer Line Mapper
    private LineMapper lineMapper;

    @Override
    public void handleLine(String s) {
        try {
            lineMapper.mapLine(s,0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLineMapper(LineMapper lineMapper) {
        this.lineMapper = lineMapper;
    }
}
