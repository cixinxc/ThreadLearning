package Base;

/*
* ��򵥵��̣߳�ʹ�ö���ı�־λ��Ӧ�ж�
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
            * ͨ����־λ�ж�
            * �˴���Ҫע�⣬interrupatFlag��Ҫ��volatile���Σ����ߴ˿���������
            *   ��֤���߳��޸�interrupatFlagʱ����while���ж�ʱ��һ����
            * ͨ����־λ���޷���sleepʱ�ж�
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