package com.example.mvcbestpractice.common;

import static com.example.mvcbestpractice.common.LocalDateUtils.LOCAL_DATE_FORMAT;
import static com.example.mvcbestpractice.common.LocalDateUtils.from;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, String> {

	@Override
	public String convertToDatabaseColumn(LocalDate attribute) {
		if (Objects.isNull(attribute)) {
			return null;
		}
		return LocalDateUtils.toString(attribute, LOCAL_DATE_FORMAT);
	}

	@Override
	public LocalDate convertToEntityAttribute(String dbData) {
		return from(dbData);
	}
}
