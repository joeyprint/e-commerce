package shop.ecommerce.UserService.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import shop.ecommerce.UserService.DTO.AuthResponse;
import shop.ecommerce.UserService.model.User;

import java.util.Date;

@Service
public class TokenService {

  @Value("${authenservice.jwt.secret}")
  private String SECRET_KEY;

  @Value("${authenservice.jwt.expiresec}")
  private long EXPIRE_IN_SECOND;

  private final int MILLISECOND= 1000;

  private Date getExpireToken() {
    return new Date(System.currentTimeMillis() + EXPIRE_IN_SECOND * MILLISECOND);
  }

  public AuthResponse createToken(User user) {
    AuthResponse authResponse = new AuthResponse();
    Date expiredDate = getExpireToken();
    String token = Jwts.builder()
            .setSubject("User")
            .claim("userId", "" + user.getId())
            .setExpiration(expiredDate)
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact();
    authResponse.setFirstname(user.getFirstname());
    authResponse.setLastname(user.getLastname());
    authResponse.setToken("Bearer " + token);
    authResponse.setExpiryDate(expiredDate.getTime());
    return authResponse;
  }

}
