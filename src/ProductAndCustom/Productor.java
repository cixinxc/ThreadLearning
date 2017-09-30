package ProductAndCustom;

public class Productor implements Runnable{
    MyQueues myQueues;
    String name;
    public Productor(MyQueues myQueues, String name) {
        this.name = name;
        this.myQueues = myQueues;
    }

    public void run() {
        System.out.println(name);
        myQueues.product();
    }
}
