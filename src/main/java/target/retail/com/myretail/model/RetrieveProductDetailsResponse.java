package target.retail.com.myretail.model;

import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class RetrieveProductDetailsResponse {

	private Long productId;
	private String name;
	private Map<Object, Object> current_price;
	// private CurrentPrice current_price;

}
