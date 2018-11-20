package shop.ecommerce.OrderService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ResponseIOException extends RuntimeException {
  public ResponseIOException(String message, Throwable cause) {
    super(message, cause);
  }
}
