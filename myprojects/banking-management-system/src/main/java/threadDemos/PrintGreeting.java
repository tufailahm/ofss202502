package threadDemos;

public class PrintGreeting extends Thread{
    Thread t1;
    public PrintGreeting(){
        t1 = new Thread(this);
        t1.setName("SCORE");
        //NEW
        t1.start();
        //
    }
    @Override
    public void run() {
        for(int i=1;i<=3;i++)
        {
            System.out.println("Welcome in OFSS called by : " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        Thread.currentThread().setName("GAME");
        PrintGreeting p1 = new PrintGreeting();
            System.out.println("Good morning "+Thread.currentThread().getName());

        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("Hello from :" +Thread.currentThread().getName());
            }
        };
        t1.start();

        PrintGreeting p2 = new PrintGreeting();
        p2.start();
    }
}
