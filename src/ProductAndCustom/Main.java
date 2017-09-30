package ProductAndCustom;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) {
        MyQueues myQueues = new MyQueues(new LinkedBlockingDeque<>(10), 10);
        D d = new D();
        d.c();
/*
        Customer c1 = new Customer(myQueues, "c1");
        Customer c2 = new Customer(myQueues, "c2");
        Customer c3 = new Customer(myQueues, "c3");

        Productor p1 = new Productor(myQueues, "p1");
        Productor p2 = new Productor(myQueues, "p2");

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(p1);
        executor.execute(p2);
        executor.execute(c1);
        executor.execute(c2);
        executor.execute(c3);
        */
    }
}

interface A{
/*
    default void a() {
        System.out.println("A");
    }
*/
}

interface A2{
/*
    default void a() {
        System.out.println("A2");
    }
    */
}
class B{

    public B() {}
    void b() {
        a();
    }
    void a() {
        System.out.println("B");
    }
}

class C extends B implements A, A2 {
    /*
    @Override
    public void a() {
        //A2.super.a();
        System.out.println("C");
    }*/
    /*
    public void c() {
        A2.super.a();
        super.a();
    }*/

/*
    @Override
    public void a() {
        A.super.a();
        A2.super.a();
        System.out.println("C");
    }*/
    void a() {
        System.out.println("C");
    }
}

class D{
    static int a;
    void aaa(int as){
        class cd {
            int c = a;
            void aaa(int as) {
                int d = a;
            }
        }
    }

    void c() {
        B c = new C();
        c.a();
        c.b();
        B b = new B();
        b.a();
        b.b();
        D[] ds = new D[2];
        System.out.println(ds[0].a);

        System.out.println( "\n222"+Character.charCount(2));
        //System.out.println((Character)('0'+3));
    }

}
