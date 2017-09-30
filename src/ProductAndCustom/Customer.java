package ProductAndCustom;

public class Customer implements Runnable{
    MyQueues myQueues;
    String name;
    public Customer(MyQueues myQueues, String name) {
        this.name = name;
        this.myQueues = myQueues;
    }

    public void run() {
        System.out.println(name);
        myQueues.custom();
    }
}
