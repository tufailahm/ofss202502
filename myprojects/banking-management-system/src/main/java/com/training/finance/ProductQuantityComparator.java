package com.training.finance;

import com.training.inheritDemos.Product;

import java.util.Comparator;

public class ProductQuantityComparator
        implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getQuantity() > o2.getQuantity())
        return 1;
        else
            return -1;
    }
}
