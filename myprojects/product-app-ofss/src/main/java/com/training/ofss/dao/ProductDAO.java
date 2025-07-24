package com.training.ofss.dao;

import com.training.ofss.anno.Author;
import com.training.ofss.model.Product;

import java.util.List;
@Author(name = "Sahana", purpose = "to implement")
public interface ProductDAO {
    public boolean saveProduct(Product product);
    public boolean updateProduct(Product product);
    public boolean deleteProduct(int productId);
    public List<Product> getProduct();
    public Product getProduct(int product);

    public List<Product> getProduct(String productName);

    public boolean isProductExistsProduct(int product);
    public List<Product> getProduct(int lowerPrice,int upperPrice);


}
