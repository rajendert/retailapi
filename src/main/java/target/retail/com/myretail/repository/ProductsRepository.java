package target.retail.com.myretail.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import target.retail.com.myretail.model.RetailProduct;

@Repository
public interface ProductsRepository extends MongoRepository<RetailProduct, String> {

	Optional<RetailProduct> findByProductId(String productId);

}
