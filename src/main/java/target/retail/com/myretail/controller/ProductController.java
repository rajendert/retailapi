package target.retail.com.myretail.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import target.retail.com.myretail.delegate.RedskyServiceDelegate;
import target.retail.com.myretail.exception.RetailAPIException;
import target.retail.com.myretail.model.RetailProduct;
import target.retail.com.myretail.model.RetrieveProductDetailsResponse;
import target.retail.com.myretail.service.ProductService;

@RestController
@RequestMapping("/products")
@Api(tags = "Product Details")
public class ProductController {

	@Autowired
	ProductService productService;

	private static final Logger LOGGER = LoggerFactory.getLogger(RedskyServiceDelegate.class);

	@GetMapping("/{productId}")
	@Operation(description = "Retrieve product details")
	/*
	 * @ApiResponses({
	 * 
	 * @ApiResponse(responseCode = "200", description = "Retrieve", content
	 * = @Content(schema = @Schema(implementation =
	 * RetrieveProductDetailsResponse.class))),
	 * 
	 * @ApiResponse(responseCode = "500", description = "Internal Server Error",
	 * content = @Content(schema = @Schema(implementation =
	 * RetailAPIException.class))) })
	 */
	public ResponseEntity<RetrieveProductDetailsResponse> retrieveProducts(@PathVariable String productId,
			HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.retrieveProducts(productId));
	}

	@PutMapping("/{productId}")
	@Operation(description = "Update product price")
	/*
	 * @ApiResponses({
	 * 
	 * @ApiResponse(responseCode = "200", description = "Retrieve", content
	 * = @Content(schema = @Schema(implementation =
	 * RetrieveProductDetailsResponse.class))),
	 * 
	 * @ApiResponse(responseCode = "500", description = "Internal Server Error",
	 * content = @Content(schema = @Schema(implementation =
	 * RetailAPIException.class))) })
	 */
	public ResponseEntity<RetrieveProductDetailsResponse> updateProductPrice(@PathVariable String productId,
			@Valid @RequestBody RetailProduct product, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.updateProductPrice(productId, product));
	}

}
