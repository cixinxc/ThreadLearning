package Base;

/*
* 查看线程Sleep时，被中断
* */
public class BaseRunnableSleepAndInterrupt implements Runnable{
    public String baseRunnableName;
    public BaseRunnableSleepAndInterrupt(String name) {
        this.baseRunnableName = name;
    }
    public void run() {
        while(true) {
            if(Thread.currentThread().isInterrupted()) {
                System.out.println(this.baseRunnableName+" is isInterrupted");
                break;
            }
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(this.baseRunnableName+" is interrupt when sleep");
                /*
                * 为什么此处还要再自己中断一次：
                *   sleep()时中断，抛出异常后会重置中断标志位。
                *   所以需要再中断一次，并通过中断的处理代码做后续处理；否则这次中断不会被响应
                * */
                Thread.currentThread().interrupt();
            }
        }
    }
}

