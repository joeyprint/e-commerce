package shop.ecommerce.UserService.interceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.web.servlet.HandlerInterceptor;
import shop.ecommerce.UserService.expcetion.JWTException;
import shop.ecommerce.UserService.expcetion.UnAuthorizedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {

  private static String BEARER = "Bearer ";
  private String SECRET;

  public TokenInterceptor(String secret) {
    this.SECRET = secret;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String token = getToken(request);
    String userId = this.getUserIdFromToken(token);
    request.setAttribute("userId", userId);
    return true;
  }

  private boolean isInvalidToken (String token){
    return token == null ||
    token.equals("") ||
    !token.startsWith(BEARER) ||
    token.length() <= BEARER.length();
  }

  private String getToken (HttpServletRequest httpServletRequest) throws UnAuthorizedException {
    String token = httpServletRequest.getHeader("Authorization");

    if (this.isInvalidToken(token)) {
      throw new UnAuthorizedException("Invalid authorization provided.");
    }

    String tokenWithoutBearer = token.substring(BEARER.length());
    return tokenWithoutBearer;
  }

  private String getUserIdFromToken(String token) throws JWTException {
    String userId;
    try {
      Jws<Claims> claims = Jwts.parser()
              .setSigningKey(this.SECRET)
              .parseClaimsJws(token);
      userId = (String) claims.getBody().get("userId");
    } catch (Exception jwtException) {
      throw new JWTException(jwtException.getMessage());
    }
    return userId;
  }
}
