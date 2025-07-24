package threadDemos;

import java.util.Scanner;

public class TimedInput {

    static String userName = null;

    public static void main(String[] args) {
        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name (30 seconds): ");
            userName = scanner.nextLine();
        });

        inputThread.start();

        try {
            inputThread.join(30000);  // Wait for 30 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (userName != null && !userName.isEmpty()) {
            System.out.println("\nWelcome, " + userName);
        } else {
            System.out.println("\nBetter luck next time");
        }
    }
}
