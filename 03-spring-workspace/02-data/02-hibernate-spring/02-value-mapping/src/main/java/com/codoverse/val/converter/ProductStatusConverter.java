package com.codoverse.val.converter;

import java.util.Objects;

import com.codoverse.val.entity.Variant;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ProductStatusConverter implements AttributeConverter<Variant, String> {

	@Override
	public String convertToDatabaseColumn(Variant attribute) {
		return Objects.isNull(attribute) ? null : attribute.name();
	}

	@Override
	public Variant convertToEntityAttribute(String dbData) {
		return Objects.isNull(dbData) || dbData.isBlank() ? null : Variant.valueOf(dbData);
	}

}
