package th.in.shopdi.FrontendService.adapter;

import org.springframework.web.client.RestTemplate;
import th.in.shopdi.FrontendService.DTO.User;

public class UserAdapter {
  public User findOrCreate(User user) {
    RestTemplate restTemplate = new RestTemplate();
//    @Value("${userservice.url}")
    String url = "http://localhost:8081";
    System.out.println("get user adpter");
    return restTemplate.postForObject(url + "/user", user, User.class);
  }
}
