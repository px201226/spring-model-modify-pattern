package com.example.mvcbestpractice.controller.dto;

import com.example.mvcbestpractice.common.UseYn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BizCustDto {


	private Long bizGroupNo; // 사업그룹번호
	private String bizCd; // 사업자코드
	private Integer custCd; // 거래처코드
	private String custNm; // 거래처명
	private String displayCustCd; // 노출거래처코드
	private Integer salesEmployCd; // 영업사원코드
	private Integer deliveryEmployCd; // 배송사원코드
	private String ownerTelNo; // 대표전화번호
	private UseYn marketbPayUseYn; // 마켓봄결제사용여부 NOTE: 매입처일때 default N
	private UseYn marketbPayCreditCardYn = UseYn.N; // 마켓봄결제_신용카드여부
	private UseYn marketbPayAccountTransferYn = UseYn.N; // 마켓봄결제_계좌이체여부
	private Integer deliveryGroupCd; // 배송그룹코드 NOTE: 매입처일때 default null
	private Integer custSectionCd; // 거래처분류코드
	private String applyTradeGradeCd; // 적용거래등급코드
	private UseYn agencyCustYn; // 대리점거래처여부 NOTE: 매입처일때 default N
	private UseYn headOfficeYn = UseYn.N; // 본사여부
	private String bizNm; // 사업자명
	private String bizNo; // 사업자번호
	private String subBizPlaceNo; // 종사업장번호
	private String ownerNm; // 대표자명
	private String companyRegistNo; // 법인등록번호
	private String bizPlaceZipNo; // 사업장우편번호(배송용 주소)
	private String bizPlaceAddr; // 사업장주소(배송용 주소)
	private String bizPlaceAddrDetail; // 사업장주소상세(배송용 주소)
	private String bizPlaceLegalDongCd; // 법정동/법정리코드(배송용 주소)
}
