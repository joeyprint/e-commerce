package shop.ecommerce.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.ecommerce.UserService.DTO.AuthResponse;
import shop.ecommerce.UserService.model.User;
import shop.ecommerce.UserService.service.TokenService;
import shop.ecommerce.UserService.service.UserService;

@CrossOrigin("*")
@RestController
public class AuthenticationController {

  @Autowired
  private UserService userService;

  @Autowired
  private TokenService tokenService;

  @PostMapping("/auth/facebook")
  public ResponseEntity<AuthResponse> authFacebook(@RequestParam(name = "accessToken", required = true) String accessToken) {
    User user = userService.findOrCreateByFacebookToken(accessToken);
    if (user != null) {
      AuthResponse authResponse = tokenService.createToken(user);
      return new ResponseEntity(authResponse, HttpStatus.OK);
    }
    return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
  }

  @GetMapping("/test")
  public String test(@RequestAttribute("userId") String userId) {
    return " Hello your userId is " + userId;
  }
}
