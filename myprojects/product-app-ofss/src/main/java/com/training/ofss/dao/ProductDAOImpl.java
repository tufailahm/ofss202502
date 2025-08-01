package com.training.ofss.dao;

import com.training.ofss.model.Product;
import com.training.ofss.util.OracleDbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    Connection connection = OracleDbConnection.getOracleConnection();
    private static final String GET_ALL_PRODUCT = "select * from products";
    private static final String GET_MAX_PRODUCT_ID = "select max(productId) from products";

    private static final String INSERT_PRODUCT = "insert into products values ( ?, ? , ? , ?, ? )";
    private static final String UPDATE_PRODUCT = "update products set productName = ?, price = ?, quantity = ?,review = ? where productId = ?";
    private static final String DELETE_PRODUCT = "delete from products where productId = ?";
    @Override
    public boolean saveProduct(Product product) {
        int result=0;
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT);
            statement.setInt(1, product.getProductId());
            statement.setString(2, product.getProductName());
            statement.setInt(3, product.getPrice());
            statement.setInt(4, product.getQuantity());
            statement.setString(5, product.getReview());
        result =  statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (result ==0 ? false:true);
    }

    @Override
    public boolean updateProduct(Product product) {
        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT);
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getReview());
            statement.setInt(5, product.getProductId());
            result = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result==0;
    }

    public boolean deleteProduct(int productId) {
        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT);
            statement.setInt(1, productId);
            result = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result==0;

    }

    //GET THE MAX PRODUCT ID
    public int getMaxProductId() {
        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_MAX_PRODUCT_ID);
            statement.setInt(1, productId);
            result = statement.executeQuer();
            return result.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Product> getProduct() {
        List<Product> products = new ArrayList<Product>();
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(GET_ALL_PRODUCT);
            while (res.next()) {
                Product product = new Product();
                product.setProductId(res.getInt(1));
                product.setProductName(res.getString(2));
                product.setPrice(res.getInt(3));
                product.setQuantity(res.getInt(4));
                product.setReview(res.getString(5));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Product getProduct(int productId) {
        Product product = new Product();
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("select * from products where productId = "+productId);
            res.next();
            product.setProductId(res.getInt(1));
            product.setProductName(res.getString(2));
            product.setPrice(res.getInt(3));
            product.setQuantity(res.getInt(4));
            product.setReview(res.getString(5));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<Product> getProduct(String productName) {
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("select * from products where productName = '"+productName+ "'");
            Product  product = new Product();
            ResultSetMetaData rsmd = res.getMetaData();
            System.out.println(rsmd.getColumnCount());

            while (res.next()) {
                product.setProductId(res.getInt(1));
                product.setProductName(res.getString(2));
                product.setPrice(res.getInt(3));
                product.setQuantity(res.getInt(4));
                product.setReview(res.getString(5));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public boolean isProductExistsProduct(int productId) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("select * from products where productId = "+productId);
            result = res.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<Product> getProduct(int lowerPrice, int upperPrice) {
        return List.of();
    }


}