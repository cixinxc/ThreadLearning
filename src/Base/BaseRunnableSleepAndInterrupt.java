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
            if(Thread.currentThread().interrupted()) {
                //System.out.println(this.baseRunnableName+" is isInterrupted");
                //break;
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
                //Thread.currentThread().interrupt();
            } finally {
                // 写在此处也可以响应中断，但是可能在中断前任然需要执行一些for语句，如果再次中断+if判断，可以使结构更好
                System.out.println(this.baseRunnableName+" is isInterrupted");
                break;
            }
        }
    }
}

