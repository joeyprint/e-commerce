package th.in.shopdi.FrontendService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import th.in.shopdi.FrontendService.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class WebController {

  @GetMapping("/")
  public String home(Model model) {
    List<Product> productList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      Product product = new Product();
      product.setProductname("Red Bag");
      product.setPrice(2000);
      product.setImageURL("https://i.pinimg.com/736x/47/8e/53/478e53e19348bff068863b3496550f95--purse-handles-purse-strap.jpg");
      productList.add(product);
    }
    model.addAttribute("products", productList);
    return "index";
  }

  @GetMapping("/product/{product_id}")
  public String productDetail(@PathVariable(name = "product_id") Long productId, Model model) {
    Product product = new Product();
    product.setDescription("<strong>เสื้อลายใหม่ !!</strong><p>สวยมาก ราคาพิเศษ</p>");
    product.setImageURL(
        "https://dynamic.zacdn.com/N6uhkiChUf926vnTvBMCfv2fJTE=/fit-in/346x500/filters:quality(95):fill(ffffff)/http://static.my.zalora.net/p/pomelo-2229-0786741-5.jpg");
    product.setPrice(450);
    product.setProductname("Evalina Wide");
    model.addAttribute("product", product);
    return "ProductDetail";
  }
}
