package target.retail.com.myretail.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CurrentPrice {	
	
	@NotEmpty(message="Value must not be empty")	
	@Min(1)
	private Double value;
	private String currency_code;
}
