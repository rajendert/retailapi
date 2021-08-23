package target.retail.com.myretail.exception;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1671244422434309654L;

	public ProductNotFoundException(String productId) {
		super(String.format("Product with Id %s not found", productId));
	}
}
