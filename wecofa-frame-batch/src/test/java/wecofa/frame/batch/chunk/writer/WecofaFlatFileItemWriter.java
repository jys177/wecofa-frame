package wecofa.frame.batch.chunk.writer;

import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.batch.item.support.AbstractFileItemWriter;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.List;

public class WecofaFlatFileItemWriter<T> extends AbstractFileItemWriter<T> {

    protected LineAggregator<T> lineAggregator;

    private Resource updateHeaderResource;

    /**
     * String Buffer : Thread Safe
     * String Builder : Thread Unsafe
     * performance : Buffer < Builder (case, single thread)
     * */
    @Override
    protected String doWrite(List<? extends T> list) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator iterator =list.iterator();
        while (iterator.hasNext()){
            T item = (T) iterator.next();
            stringBuffer.append(this.lineAggregator.aggregate(item)).append(this.lineSeparator);
        }
        return stringBuffer.toString();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.lineAggregator, "A LineAggregator must be provided.");
        if (this.append) {
            this.shouldDeleteIfExists = false;
        }
    }

    @Override
    public void setResource(Resource resource) {
        super.setResource(resource);
        updateHeaderResource =resource;
    }

    @Override
    public void close() {
        super.close();
        if(updateHeaderResource!=null){
            try {
                updateFileHeader(updateHeaderResource.getFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateFileHeader(File file) throws IOException{

        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        raf.seek(0);
        raf.writeBytes("");



    }


    public void setLineAggregator(LineAggregator<T> lineAggregator) {
        this.lineAggregator = lineAggregator;
    }
}
