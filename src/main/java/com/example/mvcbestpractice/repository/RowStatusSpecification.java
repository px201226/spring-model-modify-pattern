package com.example.mvcbestpractice.repository;

import com.example.mvcbestpractice.common.RowStatusCode;
import com.example.mvcbestpractice.entity.BaseEntity;
import org.springframework.data.jpa.domain.Specification;

public class RowStatusSpecification {


	public static Specification<BaseEntity> inActiveStatus() {
		return ((root, query, builder) ->
				builder.equal(root.get("rowStsCd"), RowStatusCode.U)
		);
	}


	public static Specification<BaseEntity> inOnlyDeletedStatus() {
		return ((root, query, builder) ->
				builder.equal(root.get("rowStsCd"), RowStatusCode.D)
		);

	}

}
