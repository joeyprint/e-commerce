package th.in.shopdi.FrontendService.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import th.in.shopdi.FrontendService.DTO.Product;

@Service
public class ProductAdapter {

    @Value("${product.service.url}")
    private String productServiceURL;

    public Product getProductDetail(long id){
        RestTemplate restTemplate = new RestTemplate();
        String url = productServiceURL + "/product/" +id;
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }
}