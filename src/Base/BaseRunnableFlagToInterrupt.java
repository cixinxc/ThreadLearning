package Base;

public class BaseRunnableFlagToInterrupt implements Runnable{
    public String baseRunnableName;
    private static int interrupatFlag = 0;
    public BaseRunnableFlagToInterrupt(String name) {
        this.baseRunnableName = name;
    }
    public static void setInterrupatFlag() {
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
        }
    }
}