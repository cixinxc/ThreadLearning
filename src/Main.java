import Base.BaseRunnable;
import Base.BaseRunnableFlagToInterrupt;
import Base.BaseRunnableSleepAndInterrupt;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new BaseRunnable("�߳�1", 20));
        BaseRunnableFlagToInterrupt runnable = new BaseRunnableFlagToInterrupt("�߳�2");
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(new BaseRunnableSleepAndInterrupt("�߳�3"));

        thread1.start();
        // thread1 �ж�
        thread1.interrupt();

        thread2.start();
        // thread2 �޸��жϱ�־λ
        runnable.setInterrupatFlag();

        thread3.start();
        // thread3 �ж�
        Thread.sleep(1);
        thread3.interrupt();


    }
}
