package threadDemos;

public class WaitNotifyDemo {

    public static void main(String[] args) {
        Thread.currentThread().setPriority(1);
        Object obj = new Object();
        Runnable r = () -> {
            try {
                System.out.println("Hello1 - 2");
                synchronized (obj) {
                    obj.wait();
                }
                System.out.println("Hello3- 3");
            } catch (InterruptedException ex) { }
        };

        System.out.println("Hello2 - 1");

        Thread t = new Thread(r);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {  }
        synchronized (obj) {
            obj.notify();   //rr
        }

    }
}
