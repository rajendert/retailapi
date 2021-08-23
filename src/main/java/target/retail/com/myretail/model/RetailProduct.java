package target.retail.com.myretail.model;

import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "products")
public class RetailProduct {

	@Id
	private String id;
	@NotEmpty(message = "ProductId cannot be empty")
	@Pattern(regexp = "^[0-9]+$", message = "{ProductId should be number}")
	private String productId;
	@NotEmpty(message = "Name cannot be empty")
	private String name;
	@NotEmpty(message = "Current price cannot be empty")
	private Map<Object, Object> current_price;
	// private CurrentPrice current_price;

}
