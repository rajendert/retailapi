package target.retail.com.myretail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import target.retail.com.myretail.delegate.RedskyServiceDelegate;
import target.retail.com.myretail.exception.ProductNotFoundException;
import target.retail.com.myretail.model.CurrentPrice;
import target.retail.com.myretail.model.RetailProduct;
import target.retail.com.myretail.model.RetrieveProductDetailsResponse;
import target.retail.com.myretail.repository.ProductsRepository;

@Service
public class ProductService {

	@Autowired
	ProductsRepository productsRepository;

	@Autowired
	RedskyServiceDelegate delegate;

	@Autowired
	RetrieveProductDetailsResponse retrieveProductDetailsResponse;

	public RetrieveProductDetailsResponse retrieveProducts(String productId) {
		RetailProduct productData = getProductById(productId);
		retrieveProductDetailsResponse.setName(delegate.getProductName(productId));
		setProductResponse(productId, productData);

		return retrieveProductDetailsResponse;
	}

	public RetrieveProductDetailsResponse updateProductPrice(String productId, RetailProduct product) {

		RetailProduct productData = getProductById(productId);

		/*
		 * CurrentPrice price = new CurrentPrice();
		 * price.setValue(product.getCurrent_price().getValue());
		 * price.setCurrency_code(product.getCurrent_price().getCurrency_code());
		 * productData.setCurrent_price(price);
		 */
		productData.setCurrent_price(product.getCurrent_price());
		productsRepository.save(productData);
		retrieveProductDetailsResponse.setName(productData.getName());
		setProductResponse(productId, productData);

		return retrieveProductDetailsResponse;
	}

	private RetailProduct getProductById(String productId) {
		RetailProduct productData = productsRepository.findByProductId(productId)
				.orElseThrow(() -> new ProductNotFoundException(productId));
		return productData;
	}

	private void setProductResponse(String productId, RetailProduct productData) {
		retrieveProductDetailsResponse.setProductId(Long.valueOf(productId));
		retrieveProductDetailsResponse.setCurrent_price(productData.getCurrent_price());
	}

}
