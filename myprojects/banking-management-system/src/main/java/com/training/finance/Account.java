package com.training.finance;
//My code
/*
My comments
 */

/**
 * This code created by Mohammad Tufail Ahmed
 */
public class Account {

    public void openAccount(){
        String accountType = "Savings";
        String accountNumber = new String("191817171");
        String name1= "Neha";
        String name2= new String("Neha");
        name1 = "Neena";
        System.out.println(name1 == name2);         //true
        System.out.println(name1.equals(name2));       //true
        name1.concat(" Kochhar");
        System.out.println(name1.concat(" Karthick"));
       name1 = name1.concat("LLL ");
    }

    public static void main(String[] args) {
        Account account1 = new Account();
        account1.openAccount();
    }
}
