package shop.ecommerce.ProductAdapter;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductAdapter{

    public Product getProductDetail(long productId){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8082/product/"+productId;
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }

}