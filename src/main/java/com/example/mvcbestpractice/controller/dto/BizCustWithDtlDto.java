package com.example.mvcbestpractice.controller.dto;

import com.example.mvcbestpractice.common.UseYn;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BizCustWithDtlDto {

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

	private LocalDate tradeEndDe; // 거래종료일
	private String tradeEndReason; // 거래종료사유
	private String postalMatterZipNo; // 우편물우편번호(세금계산서용 주소)
	private String postalMatterAddr; // 우편물주소(세금계산서용 주소)
	private String postalMatterAddrDetail; // 우편물주소상세(세금계산서용 주소)
	private String etcTelNo1; // 기타전화번호1
	private String etcTelNo2; // 기타전화번호2
	private String etcTelNo3; // 기타전화번호3
	private String addBankCd; // 추가은행코드
	private String addAccountNo; // 추가계좌번호
	private String addDepositorNm; // 추가예금주명
	private String granteeTypeCd; // 양수자유형코드
	private String memoMatter; // 메모사항
	private String memoReason; // 메모사유
}
