package demos;

import com.training.inheritDemos.Product;
import com.training.inheritDemos.ProductPriceNegativeException;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Hello1");
        try {
            Product product = new Product(1,"Glass",900,-90);
        } catch (ProductPriceNegativeException e) {
            System.out.println(e+ " happened");
        }

        try {
            System.out.println("Hello2");
            int num = 1/0;
            System.out.println("Hello3");
        } catch (Exception e) {
            System.out.println("Hello4");
        }
        finally {
            //closing
            System.out.println("Hello5");
        }
        System.out.println("Hello6");
    }
}
