package th.in.shopdi.FrontendService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import th.in.shopdi.FrontendService.model.Product;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

  @GetMapping("/")
  public String home(Model model) {
    List<Product> productList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      productList.add(new Product("sneaker", 2000, "https://static.highsnobiety.com/wp-content/uploads/2015/12/03162839/best-sneaker-featured.jpg"));
    }
    model.addAttribute("products", productList);
    return "index";
  }
}
