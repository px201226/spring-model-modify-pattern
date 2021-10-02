package com.example.mvcbestpractice.common;

import com.example.mvcbestpractice.entity.BaseEntity;
import org.springframework.data.jpa.domain.Specification;

public class BaseEntitySpecs {

	public static Specification<BaseEntity> deleted() {
		return (root, query, builder) -> {
			return builder.equal(root.get("rowStsCd"), RowStatusCode.D);
		};
	}

	public static Specification<BaseEntity> active() {
		return (root, query, builder) -> {
			return builder.notEqual(root.get("rowStsCd"), RowStatusCode.D);
		};
	}
}
