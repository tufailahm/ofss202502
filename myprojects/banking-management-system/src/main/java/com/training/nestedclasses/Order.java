package com.training.nestedclasses;

import com.training.inheritDemos.Product;

import java.util.HashSet;
import java.util.Set;

public class Order {
  private Set<Item> items = new HashSet<>();
  public void addItem(Product product, int quantity) {
    items.add(new Item(product,quantity));
      Item i = new Item(product,quantity);
      System.out.println(i.num);
      i.display();
  }
  class Item {
    private Product product;
    private int quantity;
    private int num=10;
private Item(Product product, int quantity) {
     this.product = product;
      this.quantity = quantity;
    }
    private void display(){
        System.out.println("display called");
    }
    // other methods of the Item class
  }


}
