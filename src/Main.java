import Base.BaseRunnable;
import Base.BaseRunnableFlagToInterrupt;
import Base.BaseRunnableFlagToSleepAndInterrupt;
import Base.BaseRunnableSleepAndInterrupt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

class Animal{}
class Cat extends Animal{}
class Tiger extends Cat{}
class BigTiger extends Tiger{}
public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<? super Tiger> tiger = new ArrayList<Cat>();
        tiger.add(new BigTiger());
        Object a = tiger.get(1);

        List<? extends Tiger> cs = new ArrayList<>();

    //cs.add(new Animal());     ·

        cs = new ArrayList<BigTiger>();//cs.add(new BigTiger());

        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(1);
        ThreadLocal<Integer> tl = new ThreadLocal<>();

        LinkedList<Integer> ac = new LinkedList<>();

        Thread thread1 = new Thread(new BaseRunnable("线程1", 20));
        thread1.start();
        // thread1 中断
        thread1.interrupt();

        BaseRunnableFlagToInterrupt runnable = new BaseRunnableFlagToInterrupt("线程2");
        Thread thread2 = new Thread(runnable);
        thread2.start();
        Thread.sleep(10);
        // thread2 修改中断标志位
        runnable.setInterrupatFlag();

        BaseRunnableFlagToSleepAndInterrupt runnables = new BaseRunnableFlagToSleepAndInterrupt("线程3");
        Thread thread3 = new Thread(runnables);
        thread3.start();
        //Thread.sleep(10);
        // thread2 修改中断标志位
        runnables.setInterrupatFlag();

        Thread thread4 = new Thread(new BaseRunnableSleepAndInterrupt("线程4"));
        thread4.start();
        // thread3 中断
        Thread.sleep(10);
        thread4.interrupt();


    }
}
