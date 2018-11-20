package shop.ecommerce.OrderService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class OmiseClientException extends RuntimeException {
  public OmiseClientException(String message, Throwable cause) {
    super(message, cause);
  }
}
