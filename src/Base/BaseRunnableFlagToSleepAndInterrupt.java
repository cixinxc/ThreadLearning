package Base;

public class BaseRunnableFlagToSleepAndInterrupt implements Runnable {
    public String baseRunnableName;
    public static volatile int interrupatFlag = 0;
    public BaseRunnableFlagToSleepAndInterrupt(String name) {
        this.baseRunnableName = name;
    }
    public static synchronized void setInterrupatFlag() {
        interrupatFlag = 1;
    }
    public void run() {
        while(true) {
            /*
            * 通过标志位中断
            */
            if(interrupatFlag==1) {
                System.out.println(this.baseRunnableName+" is isInterrupted");
                break;
            }
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(this.baseRunnableName+" is interrupt when sleep");
                interrupatFlag = 1;
            }
        }
    }
}