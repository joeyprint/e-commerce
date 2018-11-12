package shop.ecommerce.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(Product product) {
        Product product_object = productService.createProduct(product);
        return new ResponseEntity<Product>(product_object, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct(Product product) {
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK) ;
    }
    
    

    @GetMapping("/product/{product_id}")
    public ResponseEntity<Product> getProductDetail(@PathVariable("product_id") long productId)  {
        Product getProductDetail = productService.getProductDetail(productId);
        return new ResponseEntity<Product>(getProductDetail,HttpStatus.OK);
    }
    

}
