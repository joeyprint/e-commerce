package shop.ecommerce.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User updateAddress(long userId, String address) {
        User user = userRepository.findById(userId);
        user.setAddress(address);
        return userRepository.save(user);
    }
}
