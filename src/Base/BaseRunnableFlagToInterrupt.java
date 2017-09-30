package Base;

/*
* 最简单的线程，使用额外的标志位响应中断
* */
public class BaseRunnableFlagToInterrupt implements Runnable{
    public String baseRunnableName;
    public static  int interrupatFlag = 0;
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
            * 此处需要注意，interrupatFlag需要用volatile修饰，或者此块代码加锁：
            *   保证主线程修改interrupatFlag时，和while中判断时的一致性
            * 通过标志位：无法再sleep时中断
            */
            //
            synchronized(this)
            {
                if(this.interrupatFlag==1) {
                    System.out.println(this.baseRunnableName+" is isInterrupted");
                    break;
                }
            }
        }
    }
}