package th.in.shopdi.FrontendService.service;

import org.springframework.stereotype.Service;
import th.in.shopdi.FrontendService.adapter.UserAdapter;

@Service
public class UserService {

  private UserAdapter userAdapter;

  public UserService() {
    userAdapter = new UserAdapter();
  }

}
