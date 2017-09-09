import Base.BaseRunnable;
import Base.BaseRunnableFlagToInterrupt;
import Base.BaseRunnableSleepAndInterrupt;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new BaseRunnable("线程1", 20));
        BaseRunnableFlagToInterrupt runnable = new BaseRunnableFlagToInterrupt("线程2");
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(new BaseRunnableSleepAndInterrupt("线程3"));

        thread1.start();
        // thread1 中断
        thread1.interrupt();

        thread2.start();
        // thread2 修改中断标志位
        runnable.setInterrupatFlag();

        thread3.start();
        // thread3 中断
        Thread.sleep(1);
        thread3.interrupt();


    }
}
