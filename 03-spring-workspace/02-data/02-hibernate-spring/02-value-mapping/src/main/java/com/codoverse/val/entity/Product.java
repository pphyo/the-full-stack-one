package com.codoverse.val.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

import jakarta.persistence.CheckConstraint;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;

@Entity
@Getter
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String barcode;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, check = @CheckConstraint(constraint = "price > 100", name = "product_price_check"), precision = 20, scale = 4)
	private BigDecimal price;

	private int stock;

	private Variant variant;

	@ElementCollection
	@Column(name = "photo")
	@CollectionTable(name = "photos")
	private Collection<String> photos;

	@ElementCollection
	@CollectionTable(name = "special_prices")
	@MapKeyColumn(name = "id")
	@Column(
		name = "price",
		nullable = false,
		check = @CheckConstraint(
				name = "special_prices_price_check",
				constraint = "price > 50"),
		precision = 15
	)
	private Map<String, Double> specialPrices;

	@Transient
	private boolean deleted;

}
