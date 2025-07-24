package com.training.ofss.com.training.ofss;

import com.training.ofss.dao.ProductDAO;
import com.training.ofss.dao.ProductDAOImpl;
import com.training.ofss.model.Product;

import java.util.Scanner;

public class ProductApp {

    static Scanner sc = new Scanner(System.in);
    static ProductDAO productDAO = new ProductDAOImpl();

    public void startProductApp() {
        int choice;
        do {
            System.out.println("\n------ Product Management ------");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                //    updateProduct();
                    break;
                case 4:
               //     deleteProduct();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        if (!productDAO.isProductExistsProduct(id)) {
            System.out.print("Enter Product Name: ");
            String name = sc.next();
            System.out.print("Enter Price: ");
            int price = sc.nextInt();
            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Review: ");
            String review = sc.nextLine();

            Product p = new Product(id, name, price, qty, review);
            //this product object needs to saved in a file also
            productDAO.saveProduct(p);
            System.out.println("Product Saved successfully");
        } else {
            System.out.println("Product with id :" + id + " already exists");
        }
    }

    static void viewProducts() {
        System.out.println(productDAO.getProduct());
    }
/*
    static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (!productMap.containsKey(id)) {
            System.out.println("Product not found.");
            return;
        }

        Product p = productMap.get(id);
        System.out.print("Enter New Product Name (" + p.productName + "): ");
        String name = sc.nextLine();
        System.out.print("Enter New Price (" + p.price + "): ");
        double price = sc.nextDouble();
        System.out.print("Enter New Quantity (" + p.quantity + "): ");
        int qty = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter New Review (" + p.review + "): ");
        String review = sc.nextLine();

        productMap.put(id, new Product(id, name, price, qty, review));
        System.out.println("Product updated successfully!");
    }

    static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();
        if (productMap.remove(id) != null) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }
}
*/


}
