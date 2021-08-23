package target.retail.com.myretail.exception;

public class AuthenticationException extends RuntimeException {

	private static final long serialVersionUID = -5885433194580961941L;

	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}
}