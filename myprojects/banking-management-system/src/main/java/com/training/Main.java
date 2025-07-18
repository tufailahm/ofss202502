package com.training;


import com.training.finance.*;
import com.training.hr.*;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome in Main");
        Account account = new Account();
        account.openAccount();
        Trainee trainee = new Trainee();
        trainee.markAttendance();
        com.training.finance.Employee employee = new com.training.finance.Employee();

        Date d = new Date();
        System.out.println(d);

    }
}
class A
{
    int num=100;
}
class B
{
    public void display(){
        A a = new A();
        System.out.println(a.num);
    }
}
class C extends A
{
    public void display(){
        A a = new A();
        System.out.println(a.num);
        System.out.println(num);
    }
}