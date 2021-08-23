package target.retail.com.myretail.jwtresources;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class TokenResponse implements Serializable {

	private static final long serialVersionUID = 8317676219297719109L;

	private final String token;

	public TokenResponse(String token) {
		this.token = token;
	}

}