package com.training.inheritDemos;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1999,"Mouse",1000,999);
        Product product2 = new Product(1998,"Mouse",1000,999);

        System.out.println(product1 == product2);       //false
        System.out.println(product1.equals(product2));      //FALSE

        System.out.println(product1.hashCode());
        System.out.println(product2.hashCode());
        Employee employee1 = new Employee(1,"Hasmita");
        Employee employee2 = new Employee(1,"Hasmita");
        System.out.println(employee1.equals(employee2));

        Product p = new Product();
        p.displayProductDetails();

        Product []products = new Product[5];
        products[4] = new Product();        //allocating memory
        products[4].displayProductDetails();        //NULL POINTER EXCEPTION


        String names[] = {"Neha","Arun", "Vaishnavi", "Naveen", "Vikram", "om" , "jay"};

        System.out.println("Sorted on names -- alphabet");
        Arrays.sort(names);

        for(String s:names) {
            System.out.println(s);
        }

        //---sorting by name length
        System.out.println("Sorted on names -- length");
        Arrays.sort(names,new LengthComparator());

        for(String s:names) {
            System.out.println(s);
        }

    }
}
