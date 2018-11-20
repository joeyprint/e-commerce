package th.in.shopdi.FrontendService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import th.in.shopdi.FrontendService.DTO.CreditCard;
import th.in.shopdi.FrontendService.DTO.Order;
import th.in.shopdi.FrontendService.DTO.Payment;
import th.in.shopdi.FrontendService.DTO.Product;
import th.in.shopdi.FrontendService.adapter.OrderAdapter;
import th.in.shopdi.FrontendService.adapter.ProductAdapter;
import th.in.shopdi.FrontendService.adapter.UserAdapter;
import th.in.shopdi.FrontendService.DTO.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class WebController {

  @Autowired
  private ProductAdapter productAdapter;
  
  @Autowired
  private OrderAdapter orderAdapter;

  @Autowired
  private UserAdapter userAdapter;

  @GetMapping("/login")
  public String facebookLogin(
          @ModelAttribute("redirect") String redirect,
          Model model) {
    System.out.println("/login" + redirect);
    model.addAttribute("redirect", redirect);
    return "facebookLogin";
  }

  @GetMapping("/")
  public String home(Model model) {
    List<Product> products = productAdapter.getAllProduct();
    model.addAttribute("products", products);
    return "index";
  }

  @GetMapping("/product/{product_id}")
  public String productDetail(@PathVariable(name = "product_id") long productId, Model model) {
    Product product = productAdapter.getProductDetail(productId);
    model.addAttribute("product", product);
    return "ProductDetail";
  }

  @GetMapping("/ship")
  public String getShippInfo(
      @RequestParam("item") Optional<Long> productId,
      @CookieValue(value = "x-token", required = false) String token,
      RedirectAttributes redirectAttributes
  ) {
    if (!productId.isPresent()) {
      return "redirect:/";
    }
    redirectAttributes.addFlashAttribute("redirect", "/ship?item=" + productId.get());
    if (token == null) {
      return "redirect:/login";
    }
    User user = null;
    try {
      user = userAdapter.getProfileByToken(token);
    } catch (Exception e) {
      return "redirect:/login";
    }
    return "ShippingInfo";
  }

  @GetMapping("/ship/payment")
  public String getShipInfoWithPayment(Model model) {
    CreditCard creditCard = new CreditCard();
    creditCard.setCardnumber("1234567890123456");
    creditCard.setFullname("Putchamon Pueakaim");
    creditCard.setExpiredMonth("06");
    creditCard.setExpiredYear("21");
    model.addAttribute("creditcard", creditCard);
    return "ShippingInfo";
  }

  @GetMapping("/shipping")
  public String getShippInfo() {
    return "ShippingInfo";
  }

  @GetMapping("/addAddress")
  public String getaddAddress(Model model) {
    User user = new User();
    user.setFirstname("noname");
    user.setLastname("lastname");
    user.setAddress("1/78 Rana II,road Thakham, Bangkontheian, Bangkok 10150");
    model.addAttribute("user", user);
    return "addAddress";
  }

  @GetMapping("/payment")
  public String getCreditPayment() {
    return "addCredit";
  }

  @GetMapping("/vieworder/{order_id}")
  public String orderDetail(@PathVariable(name = "order_id") long orderId, Model model) {
    // Product product = new Product();
    // product.setDetail("<strong>เสื้อลายใหม่ !!</strong><p>สวยมาก ราคาพิเศษ</p>");
    // product.setThumbnail(
    //     "https://dynamic.zacdn.com/N6uhkiChUf926vnTvBMCfv2fJTE=/fit-in/346x500/filters:quality(95):fill(ffffff)/http://static.my.zalora.net/p/pomelo-2229-0786741-5.jpg");
    // product.setPrice(450);
    // product.setName("Evalina Wide");
    Order order = orderAdapter.getOrderDetail(orderId);
    model.addAttribute("order", order);
    return "viewOrder";
  }

}
