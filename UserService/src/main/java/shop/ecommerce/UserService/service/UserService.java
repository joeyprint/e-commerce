package shop.ecommerce.UserService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.ecommerce.UserService.DTO.FacebookAccount;
import shop.ecommerce.UserService.DAO.AuthenFacebookAdapter;
import shop.ecommerce.UserService.model.User;
import shop.ecommerce.UserService.repository.UserRepositoryInterface;


@Service
public class UserService {

    @Autowired
    private UserRepositoryInterface userRepositoryInterface;

    public User findOrCreateByFacebookToken(String facebookToken) {
        AuthenFacebookAdapter authenFacebookAdapter = new AuthenFacebookAdapter();
        FacebookAccount facebookAccount = authenFacebookAdapter.getFacebookAccount(facebookToken);

        User user = userRepositoryInterface.findByFacebookId(facebookAccount.getFacebookId());
        if (user != null) {
            return user;
        }
        User newUser = mapUserfromFacebookAccount(facebookAccount);
        return userRepositoryInterface.save(newUser);
    }

    private static User mapUserfromFacebookAccount(FacebookAccount facebookAccount) {
        User user = new User();
        System.out.println(facebookAccount.getFirstname());
        user.setFirstname(facebookAccount.getFirstname());
        user.setLastname(facebookAccount.getLastname());
        user.setFacebookId(facebookAccount.getFacebookId());
        user.setEmail(facebookAccount.getEmail());
        return user;
    }

    public User viewUserDetail(long userId) {
        return userRepositoryInterface.findById(userId);
    }

    public String getAddress(long userId) {
        return userRepositoryInterface.findById(userId).getAddress();
    }

    public User updateAddress(long userId, User user) {
        User userObject = userRepositoryInterface.findById(userId);
        userObject.setAddress(user.getAddress());
        return userRepositoryInterface.save(userObject);
    }

    public User updateUserAccount(long userId, User user) {
        User userObject = userRepositoryInterface.findById(userId);
        userObject.setFirstname(user.getFirstname());
        userObject.setLastname(user.getLastname());
        userObject.setEmail(user.getEmail());
        userObject.setTelNo(user.getTelNo());
        return userRepositoryInterface.save(userObject);
    }
}
