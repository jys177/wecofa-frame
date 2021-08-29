package wecofa.frame.thread;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.concurrent.*;

public class CallableTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallableTest.class);
    private ExecutorService threadPool = Executors.newFixedThreadPool(8);
    private List<Future> futureList = new CopyOnWriteArrayList<>();
    @Test
    public void thread(){
        RunnableImpl run = new RunnableImpl();
        run.run();

        CallableImpl call = new CallableImpl();
        try {
            String result= call.call();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void multiThread_RUNNABLE() throws ExecutionException, InterruptedException {
        for(int i=0;i<10;i++){
            RunnableImpl run = new RunnableImpl();
            Future<?> future=threadPool.submit(run);
            futureList.add(future);
        }
        while (futureList.size()>0){
            for(Future element:futureList){
                if(element.isDone()){
                    LOGGER.debug("SUCCESS");
                    futureList.remove(element);
                }
            }
        }
    }
    @Test
    public void multiThread_RUNNABLE_lambda() throws ExecutionException, InterruptedException {
        for(int i=0;i<10;i++){
            Future<?> future=threadPool.submit(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LOGGER.debug("runThread");
            });
            futureList.add(future);
        }
        while (futureList.size()>0){
            for(Future element:futureList){
                if(element.isDone()){
                    LOGGER.debug("SUCCESS");
                    futureList.remove(element);
                }
            }
        }
    }
    @Test
    public void multiThread_CALLABLE() throws ExecutionException, InterruptedException{
        for(int i=0;i<10;i++){
            CallableImpl call = new CallableImpl();
            Future<String> future=threadPool.submit(call);
            futureList.add(future);
        }
        while (futureList.size()>0){
            for(Future<String> element:futureList){
                if(element.isDone()){
                    LOGGER.debug("SUCCESS : {}" ,element.get());
                    futureList.remove(element);
                }
            }
        }
    }
    @Test
    public void multiThread_CALLABLE_lambda() throws ExecutionException, InterruptedException{
        for(int i=0;i<10;i++){
            Future<String> future=threadPool.submit(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LOGGER.debug("callThread");
                return "callThread";
            });
            futureList.add(future);
        }
        while (futureList.size()>0){
            for(Future<String> element:futureList){
                if(element.isDone()){
                    LOGGER.debug("SUCCESS : {}" ,element.get());
                    futureList.remove(element);
                }
            }
        }
    }


    private class RunnableImpl implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LOGGER.debug("runThread");
        }
    }
    private class CallableImpl implements Callable<String>{
        @Override
        public String call() throws Exception {
            LOGGER.debug("I am callable");
            return "callThread";
        }
    }
}
