package ProductAndCustom;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyQueues {
    private BlockingQueue<MyData> queue;
    private volatile int maxNum = 10;
    private static int SLEEP_TIME = 2000;

    public MyQueues() {
        queue = new LinkedBlockingQueue<>(maxNum);
    }

    public MyQueues(BlockingQueue<MyData> queue) {
        //maxNum = queue.size();
        this.queue = queue;
    }

    public MyQueues(BlockingQueue<MyData> queue, int maxNum) {
        this.maxNum = maxNum;
        queue.clear();
        this.queue = queue;
    }

    public void product() {
        try{
            while(true) {
                Thread.sleep(new Random().nextInt(SLEEP_TIME));
                if(queue.size()==maxNum) {
                    System.out.println("产品太多啦:"+queue.size());
                }
                MyData data = new MyData(""+Math.random());
                queue.offer(data);
                System.out.println(data.dataId+"is producted!");
                //queue.notify();
            }
        } catch (Exception ie) {
            System.out.println(ie.toString());
        }
    }

    public void custom() {
        try{
            while(true) {
                Thread.sleep(new Random().nextInt(SLEEP_TIME*3));
                if(queue.size()==0) {
                    System.out.println("没有产品啦:"+queue.size());
                }
                MyData data = queue.take();
                System.out.println(data.dataId+"is customed!");
                //queue.notify();
            }
        } catch (InterruptedException ie) {
            System.out.println(ie.toString());
        }
    }
}
