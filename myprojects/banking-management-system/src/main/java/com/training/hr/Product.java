package com.training.hr;

import java.math.BigDecimal;

public class Product {
  private BigDecimal price;
  private BigDecimal discount = BigDecimal.ZERO;
  public void setPrice(double price) {
    this.price = BigDecimal.valueOf(price);
  }
  public void setPrice(BigDecimal price) {
    this.price = price;
  }
  public void setPrice(BigDecimal price, 
                       BigDecimal discount) {
    this.price = price;
    this.discount = discount;
  }

  public static void main(String[] args) {
    Product p = new Product();
    p.setPrice(1.99);
    p.setPrice(BigDecimal.valueOf(1.99));
    p.setPrice(BigDecimal.valueOf(1.99),
            BigDecimal.valueOf(0.9));

    System.out.println(p.price);

  }
}
