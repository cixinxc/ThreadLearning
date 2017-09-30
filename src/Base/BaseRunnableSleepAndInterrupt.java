package Base;

/*
* �鿴�߳�Sleepʱ�����ж�
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
                * Ϊʲô�˴���Ҫ���Լ��ж�һ�Σ�
                *   sleep()ʱ�жϣ��׳��쳣��������жϱ�־λ��
                *   ������Ҫ���ж�һ�Σ���ͨ���жϵĴ������������������������жϲ��ᱻ��Ӧ
                * */
                //Thread.currentThread().interrupt();
            } finally {
                // д�ڴ˴�Ҳ������Ӧ�жϣ����ǿ������ж�ǰ��Ȼ��Ҫִ��һЩfor��䣬����ٴ��ж�+if�жϣ�����ʹ�ṹ����
                System.out.println(this.baseRunnableName+" is isInterrupted");
                break;
            }
        }
    }
}

