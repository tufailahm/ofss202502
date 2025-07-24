package threadDemos;

import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) {
        // 1. Create an ExecutorService to manage threads
        ExecutorService executor = Executors.newSingleThreadExecutor();
        System.out.println("1");
        // 2. Create a Callable task (e.g., a task that calculates a sum)
        Callable<Integer> sumCalculator = () -> {
            System.out.println("5");
            System.out.println("5.a)Calculating sum in a separate thread...");
            Thread.sleep(2000); // Simulate some work\
            System.out.println("5.b)Calculating sum in a separate thread...Now Awoke");
            int sum = 0;
            for (int i = 1; i <= 5; i++) {
                sum += i;
            }
            return sum;
        };
        System.out.println("2");
        // 3. Submit the Callable task to the ExecutorService
        Future<Integer> futureResult = executor.submit(sumCalculator);
        System.out.println("3");
        // 4. Retrieve the result from the Future object
        try {
            System.out.println("Main thread waiting for result...");
            System.out.println("4");
            Integer result = futureResult.get(); // Blocks until the task completes
            System.out.println("6");
            System.out.println("Result of Callable task: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 5. Shut down the ExecutorService
            executor.shutdown();
            System.out.println("7");
        }
        System.out.println("8");

    }
}