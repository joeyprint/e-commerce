package shop.ecommerce.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User viewUserDetail(long userId) {
        return userRepository.findById(userId);
    }

    public User updateAddress(long userId, String address) {
        User user = userRepository.findById(userId);
        user.setAddress(address);
    }

    public User addAddress(User user) {
        return userRepository.save(user);
    }
    public User getAddress(long userId){
        return userRepository.findById(userId);
    }
}
