package threadDemos;

import java.util.Scanner;

public class InputInJava {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name :");
        String name = sc.next();

        System.out.println("Welcome :"+name);
    }
}
