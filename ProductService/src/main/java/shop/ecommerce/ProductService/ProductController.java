package shop.ecommerce.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/product")
    public List<Product> getProductDetail()  {
        List<Product> getProductDetail = productService.getProductDetail(product);
        return product;
    }
    

}
