package com.example.mvcbestpractice.common;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lombok.Getter;

/**
 * ROW상태코드
 */
@Getter
public enum RowStatusCode {
	/** 사용 */
	U("USE"),
	/** 미사용 */
	N("UNUSE"),
	/** 삭제 */
	D("DELETE");

	public static String USE = U.name();
	public static String UNUSE = N.name();
	public static String DEL = D.name();
	private String status;

	RowStatusCode(String status) {
		this.status = status;
	}

	public static RowStatusCode getFromBoolean(Boolean bool) {
		if (Boolean.TRUE.equals(bool)) {
			return RowStatusCode.N;
		}
		return RowStatusCode.U;
	}

	public static RowStatusCode getFromBooleanOrNull(Boolean bool) {
		if (Objects.isNull(bool)) {
			return null;
		}
		return getFromBoolean(bool);
	}

	public static List<RowStatusCode> getFromStatusWithAll(String status) {
		List<RowStatusCode> statusCodes = new ArrayList<>();

		RowStatusCode convertedCode = Arrays.stream(values())
				.filter(e -> e.status.equals(status))
				.findFirst()
				.orElse(null);

		if (convertedCode == null) {
			statusCodes.add(RowStatusCode.U);
			statusCodes.add(RowStatusCode.N);
//			statusCodes.add(RowStatusCode.D); // NOTE : All 일 경우 D 도 허용하지 않는데, 추후 허용하게 변경한다면 추가 필요

			return statusCodes;
		}

		statusCodes.add(convertedCode);

		return statusCodes;
	}

	public static RowStatusCode getFromStatus(String status) {
		return Arrays.stream(values())
				.filter(e -> e.status.equals(status))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("UNUSE인 값을 입력하시오."));
	}

	public Boolean isUsed() {
		switch (this.status) {
			case "USE":
				return true;
			case "UNUSE":
				return false;
		}
		throw new RuntimeException("USE, UNUSE인 값을 입력하시오");
	}

	public boolean isDeleted() {
		return this == D;
	}
}
