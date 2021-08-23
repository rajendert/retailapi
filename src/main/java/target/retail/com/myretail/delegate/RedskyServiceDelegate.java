package target.retail.com.myretail.delegate;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import target.retail.com.myretail.config.RedskyServiceApiProperties;
import target.retail.com.myretail.constants.LogConstants;
import target.retail.com.myretail.model.ProductDetailsResponse;

@Component
public class RedskyServiceDelegate {

	@Autowired
	private RedskyServiceApiProperties properties;

	@Autowired
	@Qualifier("redskyApiRestTemplate")
	RestTemplate restTemplate;
	private static final String SERVICE_URL_PATTERN = "{serviceUrl}/v3/pdp/tcin/{productId}?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics&key=candidate}";

	private static final Logger LOGGER = LoggerFactory.getLogger(RedskyServiceDelegate.class);

	public String getProductName(String productId) {
		ResponseEntity<ProductDetailsResponse> productDetailsResponse = ResponseEntity.ok()
				.body(new ProductDetailsResponse());
		try {
			LOGGER.info("productId: " + productId);
			LOGGER.info("properties.getRedskyApiServiceUrl(): " + properties.getRedSkyApiServiceUrl());

			URI serviceURI = buildDynamicServiceURI(productId);
			LOGGER.info("url: " + serviceURI);
			productDetailsResponse = restTemplate.getForEntity(serviceURI, ProductDetailsResponse.class);
			return productDetailsResponse.getBody().getProduct().getItem().getProduct_description().getTitle();
		} catch (HttpServerErrorException | HttpClientErrorException e) {
			LOGGER.error(LogConstants.REDSKY_SERVICE_ERROR_LOG_MESSAGE + productId, e.getMessage(), e);
			return "";
		}

	}

	private URI buildDynamicServiceURI(String productId) {
		String serviceUrl = properties.getRedSkyApiServiceUrl();
		return UriComponentsBuilder.fromUriString(SERVICE_URL_PATTERN).buildAndExpand(serviceUrl, productId).toUri();
	}

}
