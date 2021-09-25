package com.example.mvcbestpractice.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
@UtilityClass
public class LocalDateUtils {

	public static final LocalDate MAX_DATE = LocalDate.of(9999, 12, 31);
	public static final LocalDate MIN_DATE = LocalDate.of(1000, 1, 1);
	public static final String LOCAL_DATE_FORMAT_WITH_HYPHEN = "yyyy-MM-dd";
	public static final String LOCAL_DATE_FORMAT = "yyyyMMdd";
	public static final String LOCAL_DATE_FORMAT_YM = "yyyyMM";

	/**
	 * 주로 엔터티의 속성에서 gql 스키마로 줄 때 이 하이픈 형식을 쓴다.
	 */
	public static String toString(LocalDate attribute) {
		return toString(attribute, LOCAL_DATE_FORMAT_WITH_HYPHEN);
	}

	public static String toString(LocalDate attribute, String format) {
		if (attribute == null) {
			return "";
		}
		return attribute.format(DateTimeFormatter.ofPattern(format));
	}

	/**
	 * 주로 엔터티에 넣을 때 하이픈 없는 형식을 쓴다.
	 */
	public static String toStringWithNoHyphen(LocalDate attribute) {
		if (attribute == null) {
			return "";
		}
		return attribute.format(DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT));
	}

	/**
	 * yyyyMM
	 */
	public static String toStringWithNoHyphenNoDate(LocalDate attribute) {
		String eight = toStringWithNoHyphen(attribute);
		if (eight.isEmpty()) {
			return "";
		}
		return eight.substring(0, 6);
	}

	public static LocalDate from(String attribute) {
		if (StringUtils.isEmpty(attribute)) {
			return null;
		}
		final String format = getFormat(attribute);
		validationCheck(format, attribute);
		return LocalDate.parse(attribute, DateTimeFormatter.ofPattern(format));
	}

	public static LocalDate from(String attribute, String fromPattern) {
		return LocalDate.parse(attribute, DateTimeFormatter.ofPattern(fromPattern));
	}

	public static String changeFormat(String str, String fromPattern, String toPattern) {
		LocalDate fromLocalDate = from(str, fromPattern);
		return LocalDateUtils.toString(fromLocalDate, toPattern);
	}

	private static String getFormat(String attribute) {
		return attribute.length() == 10 ? LOCAL_DATE_FORMAT_WITH_HYPHEN : LOCAL_DATE_FORMAT;
	}

	private static void validationCheck(String format, String localDate) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		df.setLenient(false);
		try {
			df.parse(localDate);
		} catch (ParseException e) {
			log.error("LocalDateParse Error : ", e);
		}
	}


	/**
	 * isLitterOrEqual.<br/>
	 * fromDe <= conditionDe
	 * @param fromDe
	 * @param conditionDe
	 * @return
	 */
	public static boolean isBeforeOrEqual(LocalDate fromDe, LocalDate conditionDe) {
		return Objects.nonNull(fromDe)
				&& Objects.nonNull(conditionDe)
				&& (fromDe.isEqual(conditionDe) || fromDe.isBefore(conditionDe));
	}

	/**
	 * isGreaterOrEqual.<br/>
	 * toDe >= conditionDe
	 * @param toDe
	 * @param conditionDe
	 * @return
	 */
	public static boolean isAfterOrEqual(LocalDate toDe, LocalDate conditionDe) {
		return Objects.nonNull(toDe)
				&& Objects.nonNull(conditionDe)
				&& (toDe.isEqual(conditionDe) || toDe.isAfter(conditionDe));
	}

	public static boolean equals(LocalDate localDate1, LocalDate localDate2) {
		if (Objects.isNull(localDate1) || Objects.isNull(localDate2)) {
			return false;
		}
		return localDate1.compareTo(localDate2) == 0;
	}

	public static boolean between(LocalDate localDate, LocalDate startDate, LocalDate endDate) {
		if (LocalDateUtils.isAfterOrEqual(localDate, startDate)
				&& LocalDateUtils.isBeforeOrEqual(localDate, endDate)) {
			return true;
		}
		return false;
	}
}
