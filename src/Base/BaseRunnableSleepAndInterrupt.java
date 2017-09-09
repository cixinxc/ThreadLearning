package Base;

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
                * Ϊʲô�˴���Ҫ���Լ��ж�һ�Σ�
                *   sleep()ʱ�жϣ��׳��쳣�󣬻���Ҫ��һЩ�����Ա�֤����һ���ԣ�
                *   ������Ҫ���ж�һ�Σ���ͨ���жϵĴ����������������
                * */
                Thread.currentThread().interrupt();
            }
        }
    }
}
