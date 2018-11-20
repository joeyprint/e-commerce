package th.in.shopdi.FrontendService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import th.in.shopdi.FrontendService.DTO.*;
import th.in.shopdi.FrontendService.adapter.OrderAdapter;
import th.in.shopdi.FrontendService.adapter.PaymentAdapter;
import th.in.shopdi.FrontendService.adapter.ProductAdapter;
import th.in.shopdi.FrontendService.adapter.UserAdapter;

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

  @Autowired
  private PaymentAdapter paymentAdapter ;

  @GetMapping("/login")
  public String facebookLogin(
          @ModelAttribute("redirect-url") String redirect,
          Model model) {
    System.out.println("/login>" + redirect + "<");
    if (redirect.length() != 0) {
      model.addAttribute("redirect", redirect);
    }

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
      RedirectAttributes redirectAttributes,
      Model model
  ) {
    if (!productId.isPresent()) {
      return "redirect:/";
    }
    redirectAttributes.addFlashAttribute("redirect-url", "/ship?item=" + productId.get());
    if (token == null) {
      return "redirect:/login";
    }
    User user = null;
    try {
      model.addAttribute("user", userAdapter.getProfileByToken(token));
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
    OrderMapObject order = orderAdapter.getOrderDetail(orderId);
    Payment payment = paymentAdapter.getPaymentByUserId(order.getUser().getId());
    model.addAttribute("order", order);
    model.addAttribute("payment", payment);
    return "viewOrder";
  }

}
