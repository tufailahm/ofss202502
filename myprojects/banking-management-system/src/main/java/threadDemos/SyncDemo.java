package threadDemos;

class PrintFullName
{
    public static synchronized  void print(String firstName,String lastName){
        System.out.println(firstName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(lastName);
    }
}
public class SyncDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                PrintFullName.print("Neha","Agrawal");
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                PrintFullName.print("Naina","Patel");
            }
        };
        t2.start();
    }

}
