package th.in.shopdi.FrontendService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.in.shopdi.FrontendService.DTO.FacebookAccount;
import th.in.shopdi.FrontendService.DTO.User;
import th.in.shopdi.FrontendService.adapter.AuthenFacebookAdapter;
import th.in.shopdi.FrontendService.adapter.UserAdapter;

@Service
public class UserService {
  private AuthenFacebookAdapter authenFacebookAdapter;

  private UserAdapter userAdapter;

  public UserService() {
    authenFacebookAdapter = new AuthenFacebookAdapter();
    userAdapter = new UserAdapter();
  }

}
