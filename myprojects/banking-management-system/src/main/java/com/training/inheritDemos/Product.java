package com.training.inheritDemos;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable, Comparable<Product>
{
    private int productId;
    private String productName;
    private int quantity;
    private int price;

    public Product() {
    }

    public Product(int productId, String productName, int quantity, int price) throws ProductPriceNegativeException {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        if(price < 0)
                throw new ProductPriceNegativeException("Price cannot be negative");
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws ProductPriceNegativeException {
        if(price<0)
           throw new ProductPriceNegativeException("Price cannot be negative");
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public void displayProductDetails(){
        System.out.println("Displaying product details");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && quantity == product.quantity && price == product.price && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, quantity, price);
    }
    @Override
    public int compareTo(Product o) {
        if(this.price > o.getPrice())
            return 1;
        else
            return -1;
    }
}
