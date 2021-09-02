package wecofa.frame.batch.chunk.writer.callback;

import org.junit.Test;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CallbackWriterTest {

    private LineAggregator<TestObject> lineAggregator =  new PassThroughLineAggregator();
    private Resource resource = null;

    public void init(){
        File file = new File("/data/output/headerCallback.txt");
        resource = new ClassPathResource(file.getPath());
        System.out.println(resource.getFilename());
    }

    @Test
    public void FileHeaderTest() throws Exception{
        init();
        List<TestObject> objectList = new ArrayList<>();
        objectList.add(new TestObject("NAME01","Content01"));
        objectList.add(new TestObject("NAME02","Content02"));
        objectList.add(new TestObject("NAME03","Content03"));
        objectList.add(new TestObject("NAME04","Content04"));

        DefaultHeaderCallback headerCallback = new DefaultHeaderCallback();
        headerCallback.setUpdateHeaderLine("HEADER01");
        DefaultFooterCallback footerCallback = new DefaultFooterCallback();
        footerCallback.setInsertToFooter("FOOTER01");

        FlatFileItemWriter<TestObject> writer = new FlatFileItemWriter();

        writer.setLineAggregator(lineAggregator);
        writer.setHeaderCallback(headerCallback);
        writer.setFooterCallback(footerCallback);
        writer.setResource(resource);
        writer.afterPropertiesSet();

        writer.open((new ExecutionContext()));
        writer.write(objectList);
        writer.close();

    }


    private class TestObject{
        private String name;
        private String content;

        public TestObject(String name, String content) {
            this.name = name;
            this.content = content;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "TestObject{" +
                    "name='" + name + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }
}
