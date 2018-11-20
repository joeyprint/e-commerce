package shop.ecommerce.OrderService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OmiseExpcetion extends ResponseStatusException {
  public OmiseExpcetion(HttpStatus status) {
    super(status);
  }

  public OmiseExpcetion(HttpStatus status, String reason) {
    super(status, reason);
  }

  public OmiseExpcetion(HttpStatus status, String reason, Throwable cause) {
    super(status, reason, cause);
  }
}
