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

    public String getAddress(long userId) {
        return userRepository.findById(userId).getAddress();
    }

    public User updateAddress(long userId, User user) {
        User userObject = userRepository.findById(userId);
        userObject.setAddress(user.getAddress());
        return userRepository.save(userObject);
    }

    public User updateUserAccount(long userId, User user) {
        User userObject = userRepository.findById(userId);
        userObject.setName(user.getName());
        userObject.setSurname(user.getSurname());
        userObject.setEmail(user.getEmail());
        userObject.setTelNo(user.getTelNo());
        return userRepository.save(userObject);
    }
}
