package org.example.restproductapp;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
 public class ProductController {

    ProductDAO productDAO = new ProductDAOImpl();

   @GetMapping
    public List<Product> getProduct(){     //JSON
        List<Product> products = productDAO.getProduct();
        return products;
    }

    @GetMapping("{productId}")     // 10.120.93.4:8080/product/109
    public ResponseEntity<Product> getProductById(@PathVariable("productId")int productId){

        ResponseEntity<Product> responseEntity = null;
        Product product = new Product();
       if(productDAO.isProductExistsProduct(productId)){
            product = productDAO.getProduct(productId);
          return new ResponseEntity<Product>(product, HttpStatus.OK);
       }
       else {
           return new ResponseEntity<Product>(product, HttpStatus.NO_CONTENT);
       }

    }
    @GetMapping("search/{productName}")
    public List<Product> getProductByName(@PathVariable("productName") String productName){
        List<Product> products = productDAO.getProduct(productName);
        return products;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveProduct(@RequestBody Product product) {
        if (productDAO.isProductExistsProduct(product.getProductId())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); // Product already exists
        }
        productDAO.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED); // Product successfully saved
    }
    @PutMapping("{productId}")
    public ResponseEntity<HttpStatus> updateProduct(@PathVariable int productId, @RequestBody Product updatedProduct) {
        if (!productDAO.isProductExistsProduct(productId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        updatedProduct.setProductId(productId); // Ensure the ID matches path variable
        productDAO.updateProduct(updatedProduct);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("{productId}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int productId) {
        if (!productDAO.isProductExistsProduct(productId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productDAO.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}