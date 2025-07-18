package com.training.finance;

public class Employee {
    int salary = 120;
   int newSalary = 100;
    public void display(){
    salary++;
    salary = newSalary--;
    System.out.println(salary++);
        System.out.println(--newSalary);
    }
    public static void main(String[] args) {
        Employee e = new Employee();
        e.display();

        long num=100;
        int marks = (int)num;

        float grade= 90.2f;

        byte b1=5;
        byte b2=5;
        byte b3 = (byte) (b1+b2);
        System.out.println(b3);

        byte a = 127, b = 5;
     //   byte c = a+b;           // compilation fails

        int d = a + b;          // d is 132
        byte e1 = (byte)(a+b);   // e is -124  (type overflow, because 127 is the max byte value)
        int f = a/b;            // f is 25    (a/b is 25 because it is an int)
        float g = a/b;          // g is 25.0F (result of the a/b can be implicitly or
        float h = (float)(a/b); // h is 25.0F  explicitly casted to float, but a/b is still 25)
        float i = (float)a/b;   // i is 25.4F (when either a or b
        float j = a/(float)b;   // j is 25.4F  is float the a/b becomes float)
        b = (byte)(b+1);        // explicit casting is required, because b+1 is an int
        b++;                    // no casting is required for ++ and -- operators
        char x = 'x';
        char y = ++x;           // arithmetic operations work with character codes

        int marks1 =120;
        byte result = (byte) marks1++;
        byte result2 = 121;


        int d1=10;
        int d2=20;

        boolean res = d1 > d2 & d2++ < 30;

        System.out.println("d1 :"+d1);      //10        //10
        System.out.println("d2 :"+d2);      //20        //21
        System.out.println("Result :"+res); //false     //false

        char status = 'N';
        double cost = 10;
        double price = switch (status) {
            case 'S', 'N' -> cost += 1;
            case 'D' -> {
                double discount = cost*0.2;
                cost -= discount;
                yield cost;
            }
            case 'E' -> 0;
            default -> 3;
        };


    }
}
