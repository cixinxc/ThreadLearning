import Base.BaseRunnable;
import Base.BaseRunnableFlagToInterrupt;
import Base.BaseRunnableFlagToSleepAndInterrupt;
import Base.BaseRunnableSleepAndInterrupt;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(1);
        ThreadLocal<Integer> tl = new ThreadLocal<>();
        while(true) {
            String str = in.nextLine();
            if(str.length()==0) {
                System.out.println("0000");
                break;
            }
        }

        LinkedList<Integer> ac = new LinkedList<>();

        Thread thread1 = new Thread(new BaseRunnable("�߳�1", 20));
        thread1.start();
        // thread1 �ж�
        thread1.interrupt();

        BaseRunnableFlagToInterrupt runnable = new BaseRunnableFlagToInterrupt("�߳�2");
        Thread thread2 = new Thread(runnable);
        thread2.start();
        Thread.sleep(100);
        // thread2 �޸��жϱ�־λ
        runnable.setInterrupatFlag();

        BaseRunnableFlagToSleepAndInterrupt runnables = new BaseRunnableFlagToSleepAndInterrupt("�߳�3");
        Thread thread3 = new Thread(runnables);
        thread3.start();
        Thread.sleep(100);
        // thread2 �޸��жϱ�־λ
        runnables.setInterrupatFlag();

        Thread thread4 = new Thread(new BaseRunnableSleepAndInterrupt("�߳�4"));
        thread4.start();
        // thread3 �ж�
        Thread.sleep(1);
        thread4.interrupt();


    }
}
