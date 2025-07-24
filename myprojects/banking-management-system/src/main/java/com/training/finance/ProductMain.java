package com.training.finance;

import com.training.inheritDemos.Product;
import java.util.*;
interface Review
{
    void printReview(String star);
}


public class ProductMain {
    public static void main(String[] args) throws Exception {
        Product product1 = new Product(1999, "Mouse", 1000, 999);
        Product product2 = new Product(1998, "Laptop", 12, 122);
        Product product3 = new Product(123, "Apple", 1333, 9);
        List<Product> products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        System.out.println("Sort on price");
        Collections.sort(products);
        for (Product p : products) {
            System.out.println(p);
        }
        //sort by quantity
        System.out.println("Sort on quantity");
        Collections.sort(products, new ProductQuantityComparator());
        for (Product p2 : products) {
            System.out.println(p2);
        }
        //sort by price -- desc
        System.out.println("Sort on price - DESC");
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() < o2.getPrice())
                    return 1;
                else
                    return -1;
            }
        });
        for (Product p1 : products) {
            System.out.println(p1);
        }


    //
    Review review = new Review() {
        @Override
        public void printReview(String star) {
            System.out.println(("Review is good"));
        }
    };
    review.printReview("5");


    //sort by quantity desc
        System.out.println("Print by quantity desc");
        Collections.sort(products, (p1,p2) -> Integer.compare(p1.getQuantity(), p2.getQuantity()));
        for (Product p1 : products) {
            System.out.println(p1);
        }

}

    }