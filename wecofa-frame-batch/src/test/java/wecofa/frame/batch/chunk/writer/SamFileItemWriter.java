package wecofa.frame.batch.chunk.writer;

import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.batch.item.support.AbstractItemStreamItemWriter;

import java.util.List;

public class SamFileItemWriter<T> extends AbstractItemStreamItemWriter<T> {

    protected LineAggregator<T> lineAggregator;

    @Override
    public void write(List<? extends T> list) throws Exception {

    }
}
