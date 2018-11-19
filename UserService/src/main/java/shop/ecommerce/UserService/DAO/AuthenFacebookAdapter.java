package shop.ecommerce.UserService.DAO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import shop.ecommerce.UserService.DTO.FacebookAccount;

public class AuthenFacebookAdapter {

  public FacebookAccount getFacebookAccount(String accessToken) {
    RestTemplate restTemplate = new RestTemplate();
    String graphFacebook = "https://graph.facebook.com/v3.2/me";
    String fields = "name,first_name,last_name,gender,email";
    String url = String.format("%s?fields=%s&access_token=%s", graphFacebook, fields, accessToken);
    return restTemplate.getForObject(String.format(url) , FacebookAccount.class);
  }
}
