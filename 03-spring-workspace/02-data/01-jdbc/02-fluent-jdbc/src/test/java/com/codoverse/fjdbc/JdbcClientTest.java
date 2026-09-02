package com.codoverse.fjdbc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.jdbc.core.simple.JdbcClient;

import com.codoverse.fjdbc.models.dto.ProductSummaryDto;

@JdbcTest
public class JdbcClientTest {
	
	@Autowired
	private JdbcClient jdbcClient;
	
	@Test
	void sholudFetchProductSummaries() {
		jdbcClient.sql("INSERT INTO products (id, name, price) VALUES (1, 'Gaming Monitor', 300.00)").update();
		jdbcClient.sql("INSERT INTO product_details (product, remark, sku) VALUES (1, '4K Display', 'MON-4K')").update();
		
		String sql = """
				SELECT p.id, p.name, p.price, pd.sku
				FROM products p
				LEFT JOIN product_details pd
				ON p.id = pd.product
				WHERE p.id = :id""";
		
		List<ProductSummaryDto> result = jdbcClient.sql(sql)
											.param("id", 1L)
											.query(ProductSummaryDto.class)
											.list();
		
		assertThat(result).hasSize(1);
		assertThat(result.get(0).name()).isEqualTo("Gaming Monitor");
		assertThat(result.get(0).sku()).isEqualTo("MON-4K");
	}

}
