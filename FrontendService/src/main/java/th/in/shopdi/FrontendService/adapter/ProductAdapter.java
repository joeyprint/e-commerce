package th.in.shopdi.FrontendService.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import th.in.shopdi.FrontendService.DTO.Product;

import java.util.List;

@Service
public class ProductAdapter {

    @Value("${product.service.url}")
    private String productServiceURL;

    public List<Product> getAllProduct(){
        RestTemplate restTemplate = new RestTemplate();
        String url = productServiceURL + "/products";
        List<Product> products = restTemplate.getForObject(url, List.class);
        return products;
    }

    public Product getProductDetail(long id){
        RestTemplate restTemplate = new RestTemplate();
        String url = productServiceURL + "/product/" +id;
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }
}