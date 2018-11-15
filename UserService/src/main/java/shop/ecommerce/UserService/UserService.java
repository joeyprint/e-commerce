package shop.ecommerce.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User updateAddress(User user) {
        return userRepository.save(user);
    }
}
