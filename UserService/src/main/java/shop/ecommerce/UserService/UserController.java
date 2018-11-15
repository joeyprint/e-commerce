package shop.ecommerce.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> viewUserDetail(@PathVariable(name = "id") long userId) {
        User user_object = UserService.viewUserDetai(userId);
        return new ResponseEntity<User>(user_object, HttpStatus.OK);
    }

    @PostMapping("/user/{id}/address")
    public ResponseEntity<User> updateAddress(@PathVariable(name = "id") long userId) {
        User user_object = UserService.updateAddress(userId, address);
        return new ResponseEntity<User>(user_object, HttpStatus.OK);
    }

}
