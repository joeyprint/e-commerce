package shop.ecommerce.UserService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;
import shop.ecommerce.UserService.interceptor.TokenInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Value("${authenservice.jwt.secret}")
  private String jwtSecret;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(myInterceptor());
  }

  @Bean
  public MappedInterceptor myInterceptor() {
    return new MappedInterceptor(
            new String[] {"/me"},
            new TokenInterceptor(jwtSecret));
  }
}
