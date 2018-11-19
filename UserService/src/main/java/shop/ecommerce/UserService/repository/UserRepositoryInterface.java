package shop.ecommerce.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ecommerce.UserService.model.User;

@Repository
public interface UserRepositoryInterface extends JpaRepository<User,Long>{

    User findById(long id);

    User findByFacebookId(String facebookId);

}
