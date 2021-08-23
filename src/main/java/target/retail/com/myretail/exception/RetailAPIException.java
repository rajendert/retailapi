package target.retail.com.myretail.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetailAPIException {

	protected static final long serialVersionUID = 3646393404556997914L;
	
	private LocalDateTime timestamp;
	private String message;
	private String details;

	public RetailAPIException(LocalDateTime timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}

	public RetailAPIException(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

}
