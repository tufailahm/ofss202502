package model;

import java.util.Objects;

public class Product {
    private int productId;
    private String productName;
    private int price;
    private int quantity;
    private String review;

    public Product() {
    }

    public Product(int productId, String productName, int price, int quantity, String review) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.review = review;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && price == product.price && quantity == product.quantity && Objects.equals(productName, product.productName) && Objects.equals(review, product.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, price, quantity, review);
    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", review='" + review + '\'' +
                '}';
    }
}
