package com.training;


import com.training.finance.*;
import com.training.hr.*;
import com.training.inheritDemos.Product;
import com.training.ofss.util.OracleDbConnection;

import java.io.*;
import java.sql.Connection;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Product product = new Product(11,"Sunscreen",1, 450);
        ObjectOutputStream stream =
                new ObjectOutputStream(
                        new FileOutputStream(new File("c:\\logs\\product.txt")));
        stream.writeObject(product);
        System.out.println("Product saved in file");

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