package threadDemos;

public class INterruptDemo {
    public static void main(String[] args) {
        Runnable r = () -> {
            Thread ct = Thread.currentThread(); // locate current thread object
            for(int i=1;i<=5;i++){
                System.out.println("Hello Tufail");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
            System.out.println(ct + "is running");
            while(!ct.isInterrupted()) { // check interrupt signal when running
                // perform thread actions
                System.out.println("Hey I got interrupted");
                try {
                    Thread.sleep(1000);
                    System.out.println("Hello Tufail");// enter timed waiting state for 1000 milliseconds
                }catch(InterruptedException ex) {
                    // perform interrupted when waiting actions
                 //   return;
                }
                //iif user fails to do something in n iteration
                ct.interrupt();
            }
        }; // getting to the end of the run method terminates the thread
        Thread t = new Thread(r);
        t.start();
        t.interrupt(); // when thread is in the running state it is not forced to check this signal

    }
}
