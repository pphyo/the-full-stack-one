package com.codoverse.cf;

import org.springframework.core.convert.converter.Converter;

public class StringToProductConverter implements Converter<String, Product> {

	@Override
	public Product convert(String source) {
		return new Product(Integer.parseInt(source), "Sample Product");
	}

}
