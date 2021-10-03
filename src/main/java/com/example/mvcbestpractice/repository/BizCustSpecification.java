package com.example.mvcbestpractice.repository;

import static com.example.mvcbestpractice.entity.QBizCust.bizCust;

import com.example.mvcbestpractice.entity.BizCustId;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

public class BizCustSpecification {

	public static Predicate by(Iterable<BizCustId> ids) {
		BooleanBuilder builder = new BooleanBuilder();

		for (BizCustId id : ids) {
			builder.or(by(id.getBizGroupNo(), id.getBizCd(), id.getCustCd()));
		}

		return builder;
	}

	public static BooleanExpression by(Long bizGroupNo, String bizCd, Integer custCd) {
		return bizCust.bizGroupNo.eq(bizGroupNo)
				.and(bizCust.bizCd.eq(bizCd))
				.and(bizCust.custCd.eq(custCd));
	}
}
