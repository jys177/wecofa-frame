package wecofa.frame.batch.chunk.writer.callback;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

import java.io.IOException;
import java.io.Writer;

public class DefaultHeaderCallback implements FlatFileHeaderCallback {

    private String updateHeaderLine;

    private HeaderStruct headerStruct;

    private boolean existHeader=false;

    public String getLineFromStruct(HeaderStruct headerStruct){
        return null;
    }


    public void setHeaderStruct(HeaderStruct headerStruct) {
        this.headerStruct = headerStruct;
    }

    public boolean isExistHeader() {
        return existHeader;
    }

    public String getUpdateHeaderLine(){
        return updateHeaderLine;
    }
    public void setUpdateHeaderLine(String updateHeaderLine) {
        this.updateHeaderLine = updateHeaderLine;
    }


    //TODO
    //private T inputObject;

    @Override
    public void writeHeader(Writer writer) throws IOException {
        writer.write(updateHeaderLine);
        existHeader=true;
    }

}
