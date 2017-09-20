package Base;

/*
* 最简单的线程，使用interrupted()/isInterrupted响应中断
* */
public class BaseRunnable implements Runnable{
    public String baseRunnableName;
    public int yieldNum;
    public BaseRunnable(String name, int yieldNum) {
        this.yieldNum = yieldNum;
        this.baseRunnableName = name;
    }
    public void run() {
        while(true) {
            /*
            * 没有break时
            *   interrupted()     获得中断标志位，然后重置，此程序中只输出一次
            *   isInterrupted()   获得中断标志位，此程序中一直输出
            * 有break时
            *   二者效果一致
            */
            if(Thread.currentThread().interrupted()) {
                System.out.println(this.baseRunnableName+" is isInterrupted");
                break;
            }
        }
    }
}
