package th.in.shopdi.FrontendService.adapter;

import org.springframework.web.client.RestTemplate;
import th.in.shopdi.FrontendService.DTO.FacebookAccount;

public class AuthenFacebookAdapter {
  public FacebookAccount getFacebookAccount(String accessToken) {
    RestTemplate restTemplate = new RestTemplate();
//    @Value("${facebookURL}")
    String graphFacebook = "https://graph.facebook.com/v3.2/me";
    String fields = "name,first_name,last_name,gender,email";
    String url = String.format("%s?fields=%s&access_token=%s", graphFacebook, fields, accessToken);
    System.out.println("getFacebookAccount");
    return restTemplate.getForObject(String.format(url) , FacebookAccount.class);
  }
}
