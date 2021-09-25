package com.example.mvcbestpractice.common;


import javax.xml.bind.ValidationException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UseYn {
	Y(true), N(false);

	boolean isTrue;

	public static UseYn getFromBoolean(Boolean value) {
		if (value == null) {
			return N;
		}
		return value ? Y : N;
	}

	public static UseYn getFromString(String yn) {
		if ("Y".equals(yn)) {
			return Y;
		} else if ("N".equals(yn)) {
			return N;
		}
		throw new IllegalArgumentException("UseYn");
	}

	public static boolean isTrue(UseYn useYn) {
		if (useYn == null) {
			return false;
		}
		return useYn.isTrue;
	}

	public String toYnString() {
		return isTrue ? "Y" : "N";
	}
}
