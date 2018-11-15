package shop.ecommerce.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    
    

    @Autowired
    private UserRepository userRepository;

    public User updateAddress(User user) {
        return userRepository.save(user);
    }
    
    public User addAddress(User user){
        return userRepository.save(user);
    }
    public User getAddress(long userId){
        return userRepository.findById(userId);
    }
}
