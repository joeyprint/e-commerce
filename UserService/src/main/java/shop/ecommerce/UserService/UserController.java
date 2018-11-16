package shop.ecommerce.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> viewUserDetail(@PathVariable(name = "id") long userId) {
        User user_object = userService.viewUserDetail(userId);
        return new ResponseEntity<User>(user_object, HttpStatus.OK);
    }

    @GetMapping("/user/{id}/address")
    public ResponseEntity<String> getAddress(@PathVariable(name = "id") long userId) {
        String address = userService.getAddress(userId);
        return new ResponseEntity<String>(address, HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUserAccount(@PathVariable(name = "id") long userId, @Valid @RequestBody User user) {
        User user_object = userService.updateUserAccount(userId, user);
        return new ResponseEntity<User>(user_object, HttpStatus.OK);
    }

    @PutMapping("/user/{id}/address")
    public ResponseEntity<User> updateAddress(@PathVariable(name = "id") long userId, @Valid @RequestBody User user) {
        User user_object = userService.updateAddress(userId, user);
        return new ResponseEntity<User>(user_object, HttpStatus.OK);
    }

}
