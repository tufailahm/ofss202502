package dao;


import model.Product;

import java.util.List;
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
