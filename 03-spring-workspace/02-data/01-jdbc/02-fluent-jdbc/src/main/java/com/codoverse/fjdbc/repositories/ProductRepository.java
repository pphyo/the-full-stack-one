package com.codoverse.fjdbc.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import com.codoverse.fjdbc.models.Product;
import com.codoverse.fjdbc.models.dto.ProductSummaryDto;

public interface ProductRepository extends ListCrudRepository<Product, Long> {
	
	@Query("""
			SELECT p.id, p.name, p.price, pd.sku FROM products p
				LEFT JOIN prdocut_details pd
				ON p.id = pd.product
			""")
	List<ProductSummaryDto> findSummaries();

}
