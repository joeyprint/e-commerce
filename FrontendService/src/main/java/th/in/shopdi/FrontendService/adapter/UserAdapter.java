package th.in.shopdi.FrontendService.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.in.shopdi.FrontendService.DTO.User;

@Service
public class UserAdapter {

  @Value("${user.service.url}")
  private String userServiceURL;

  public User getProfileByToken(String token) {
    RestTemplate restTemplate = new RestTemplate();
    String url = userServiceURL + "/me";

    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", token);
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.GET, request, User.class);
    return response.getBody();
  }

  public User getUserDetail(long userId) {
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8081";
    return restTemplate.getForObject(url + "/user/" + userId, user, User.class);
  }
}
