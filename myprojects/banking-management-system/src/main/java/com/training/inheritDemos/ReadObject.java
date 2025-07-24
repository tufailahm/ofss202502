package com.training.inheritDemos;

import java.io.*;

public class ReadObject {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Product product = new Product();
        ObjectInputStream stream =
                new ObjectInputStream(
                        new FileInputStream(new File("c:\\logs\\product.txt")));
        product = (Product) stream.readObject();
        System.out.println(product);

    }
}
