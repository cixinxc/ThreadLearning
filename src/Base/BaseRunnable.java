package Base;

/*
* ��򵥵��̣߳�ʹ��interrupted()/isInterrupted��Ӧ�ж�
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
            * û��breakʱ
            *   interrupted()     ����жϱ�־λ��Ȼ�����ã��˳�����ֻ���һ��
            *   isInterrupted()   ����жϱ�־λ���˳�����һֱ���
            * ��breakʱ
            *   ����Ч��һ��
            */
            if(Thread.currentThread().interrupted()) {
                System.out.println(this.baseRunnableName+" is isInterrupted");
                break;
            }
        }
    }
}
