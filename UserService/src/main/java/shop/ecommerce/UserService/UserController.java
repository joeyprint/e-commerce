package shop.ecommerce.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> viewUserDetail(@PathVariable (name = "id") long userId){
        User user_object = userService.viewUserDetail(userId);
        return new ResponseEntity<User>(user_object, HttpStatus.OK);
    }

    @PostMapping("/user/{id}/add")
    public ResponseEntity<User> addAddress(@PathVariable (name = "id") User userId){
        User address = userService.addAddress(userId);
        return new ResponseEntity<User>(address, HttpStatus.OK);
    }
}
