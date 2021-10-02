package com.example.mvcbestpractice.repository;

import static com.example.mvcbestpractice.entity.QBizCust.bizCust;
import static com.example.mvcbestpractice.entity.QBizCustDtl.bizCustDtl;
import static com.querydsl.core.types.Projections.constructor;

import com.example.mvcbestpractice.controller.dto.BizCustDto;
import com.example.mvcbestpractice.controller.dto.BizCustSearchCondition;
import com.example.mvcbestpractice.controller.dto.BizCustWithDtlDto;
import com.example.mvcbestpractice.entity.BizCustId;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BizCustRepositoryCustomImpl implements BizCustRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<BizCustDto> findAll(Long bizGroupNo, BizCustSearchCondition condition) {
		List<BizCustDto> bizCustDtos = queryFactory
				.select(
						constructor(
								BizCustDto.class,
								bizCust.bizGroupNo,
								bizCust.bizCd,
								bizCust.custCd,
								bizCust.custNm,
								bizCust.displayCustCd,
								bizCust.salesEmployCd,
								bizCust.deliveryEmployCd,
								bizCust.ownerTelNo,
								bizCust.marketbPayUseYn,
								bizCust.marketbPayCreditCardYn,
								bizCust.marketbPayAccountTransferYn,
								bizCust.deliveryGroupCd,
								bizCust.custSectionCd,
								bizCust.applyTradeGradeCd,
								bizCust.agencyCustYn,
								bizCust.headOfficeYn,
								bizCust.bizNm,
								bizCust.bizNo,
								bizCust.subBizPlaceNo,
								bizCust.ownerNm,
								bizCust.companyRegistNo,
								bizCust.bizPlaceZipNo,
								bizCust.bizPlaceAddr,
								bizCust.bizPlaceAddrDetail,
								bizCust.bizPlaceLegalDongCd
						))
				.from(bizCust)
				.where(getBooleanBuilderCondition(bizGroupNo, condition))
				.fetch();

		return bizCustDtos;
	}

	@Override
	public List<BizCustWithDtlDto> findByIdWithDtl(BizCustId bizCustId) {

		List<BizCustWithDtlDto> fetch = queryFactory
				.select(
						constructor(
								BizCustWithDtlDto.class,
								bizCust.bizGroupNo,
								bizCust.bizCd,
								bizCust.custCd,
								bizCust.custNm,
								bizCust.displayCustCd,
								bizCust.salesEmployCd,
								bizCust.deliveryEmployCd,
								bizCust.ownerTelNo,
								bizCust.marketbPayUseYn,
								bizCust.marketbPayCreditCardYn,
								bizCust.marketbPayAccountTransferYn,
								bizCust.deliveryGroupCd,
								bizCust.custSectionCd,
								bizCust.applyTradeGradeCd,
								bizCust.agencyCustYn,
								bizCust.headOfficeYn,
								bizCust.bizNm,
								bizCust.bizNo,
								bizCust.subBizPlaceNo,
								bizCust.ownerNm,
								bizCust.companyRegistNo,
								bizCust.bizPlaceZipNo,
								bizCust.bizPlaceAddr,
								bizCust.bizPlaceAddrDetail,
								bizCust.bizPlaceLegalDongCd,
								bizCustDtl.tradeEndDe,
								bizCustDtl.tradeEndReason,
								bizCustDtl.postalMatterZipNo,
								bizCustDtl.postalMatterAddr,
								bizCustDtl.postalMatterAddrDetail,
								bizCustDtl.etcTelNo1,
								bizCustDtl.etcTelNo2,
								bizCustDtl.etcTelNo3,
								bizCustDtl.addBankCd,
								bizCustDtl.addAccountNo,
								bizCustDtl.addDepositorNm,
								bizCustDtl.granteeTypeCd,
								bizCustDtl.memoMatter,
								bizCustDtl.memoReason
						))
				.from(bizCust)
				.join(bizCustDtl)
				.on(
						bizCust.bizGroupNo.eq(bizCustDtl.bizGroupNo),
						bizCust.bizCd.eq(bizCustDtl.bizCd),
						bizCust.custCd.eq(bizCustDtl.custCd)
				)
				.where(
						bizCust.bizGroupNo.eq(bizCustId.getBizGroupNo()),
						bizCust.bizCd.eq(bizCustId.getBizCd()),
						bizCust.custCd.eq(bizCustId.getCustCd())
				)
				.fetch();

		return fetch;
	}

	private BooleanBuilder getBooleanBuilderCondition(Long bizGroupNo, BizCustSearchCondition condition) {

		BooleanBuilder builder = new BooleanBuilder();

		builder.and(bizCust.bizGroupNo.eq(bizGroupNo));

		if (condition.getBizCd() != null) {
			builder.and(bizCust.bizCd.eq(condition.getBizCd()));
		}

		if (condition.getCustName() != null) {
			builder.and(bizCust.custNm.like("%" + condition.getCustName() + "%"));
		}

		if (condition.getSalesEmployCd() != null) {
			builder.and(bizCust.salesEmployCd.eq(condition.getSalesEmployCd()));
		}

		if (condition.getDeliveryEmployCd() != null) {
			builder.and(bizCust.deliveryEmployCd.eq(condition.getDeliveryEmployCd()));
		}

		return builder;
	}
}
