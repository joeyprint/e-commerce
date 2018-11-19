package shop.ecommerce.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> findOrCreate(@Valid @RequestBody User user) {
        System.out.println("inbound user find UserService /user");
        System.out.println(user.getFirstname());
        return new ResponseEntity<Optional<User>>(userService.findOrCreate(user), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> viewUserDetail(@PathVariable(name = "id") long userId) {
        User user = userService.viewUserDetail(userId);
        if (user == null) {
            throw new UserNotFoundException("id:" + userId);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
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
