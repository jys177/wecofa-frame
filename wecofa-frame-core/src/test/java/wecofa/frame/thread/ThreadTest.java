package wecofa.frame.thread;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class ThreadTest {
    private final static Logger logger= LoggerFactory.getLogger(ThreadTest.class);
    private List<CompletableFuture> futureList = new ArrayList<>();
    private ExecutorService threadPool = Executors.newScheduledThreadPool(4);

    @Test
    public void CompletionFutureTest() throws Exception {
        for (int i=0;i<10;i++){
            int num=i+1;
            submit(num);
        }
        for(CompletableFuture<String> future: futureList){
            receive(future);
        }
    }
    public void receive(CompletableFuture<String> completableFuture) throws Exception{
        CompletableFuture future=completableFuture.thenAcceptAsync(this::response);
        future.get(500,TimeUnit.MILLISECONDS);
    }


    public void submit(int num) {

        CompletableFuture<String> completableFuture =CompletableFuture.supplyAsync(()->(
                        ""+getMessage(num)+(num)),threadPool
                );
        futureList.add(completableFuture);
    }
    public String getMessage(int num) {
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String msg="Message";
        logger.debug(msg+num);
        return msg;
    }
    public void response(String s){
        logger.debug("[response]"+s);
    }

}
