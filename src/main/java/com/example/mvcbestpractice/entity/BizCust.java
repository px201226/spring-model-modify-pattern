package com.example.mvcbestpractice.entity;

import com.example.mvcbestpractice.common.UseYn;
import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Getter
@DynamicUpdate
@NoArgsConstructor @AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "entityBuilder", toBuilder = true) @IdClass(BizCustId.class)
public class BizCust {

	@Id @Column(name = "BIZ_GROUP_NO", nullable = false)
	@EqualsAndHashCode.Include
	private Long bizGroupNo; // 사업그룹번호

	@Id @Column(name = "BIZ_CD", length = 5, nullable = false)
	@EqualsAndHashCode.Include
	private String bizCd; // 사업자코드

	@Id @Column(name = "CUST_CD", nullable = false)
	@EqualsAndHashCode.Include
	private Integer custCd; // 거래처코드

	@Column(name = "CUST_NM", length = 50, nullable = false)
	private String custNm; // 거래처명

	@Column(name = "DISPLAY_CUST_CD", length = 14, nullable = false)
	private String displayCustCd; // 노출거래처코드

	@Column(name = "SALES_EMPLOY_CD", length = 10)
	private Integer salesEmployCd; // 영업사원코드

	@Column(name = "DELIVERY_EMPLOY_CD", length = 10)
	private Integer deliveryEmployCd; // 배송사원코드

	@Column(name = "OWNER_TEL_NO", length = 20, nullable = false)
	private String ownerTelNo; // 대표전화번호

	@Column(name = "MARKETB_PAY_USE_YN", length = 1, nullable = false) @Enumerated(EnumType.STRING)
	private UseYn marketbPayUseYn; // 마켓봄결제사용여부 NOTE: 매입처일때 default N

	@Column(name = "MARKETB_PAY_CREDIT_CARD_YN", length = 1) @Enumerated(EnumType.STRING) @Default
	private UseYn marketbPayCreditCardYn = UseYn.N; // 마켓봄결제_신용카드여부

	@Column(name = "MARKETB_PAY_ACCOUNT_TRANSFER_YN", length = 1) @Enumerated(EnumType.STRING) @Default
	private UseYn marketbPayAccountTransferYn = UseYn.N; // 마켓봄결제_계좌이체여부

	@Column(name = "DELIVERY_GROUP_CD")
	private Integer deliveryGroupCd; // 배송그룹코드 NOTE: 매입처일때 default null

	@Column(name = "CUST_SECTION_CD")
	private Integer custSectionCd; // 거래처분류코드

	@Column(name = "APPLY_TRADE_GRADE_CD", length = 4, nullable = false)
	private String applyTradeGradeCd; // 적용거래등급코드

	@Column(name = "AGENCY_CUST_YN", length = 1, nullable = false) @Enumerated(EnumType.STRING)
	private UseYn agencyCustYn; // 대리점거래처여부 NOTE: 매입처일때 default N

	@Column(name = "HEAD_OFFICE_YN", length = 1) @Enumerated(EnumType.STRING) @NotNull
	@Default
	private UseYn headOfficeYn = UseYn.N; // 본사여부

	@Column(name = "BIZ_NM", length = 70, nullable = false)
	private String bizNm; // 사업자명

	@Column(name = "BIZ_NO", length = 10, nullable = false)
	private String bizNo; // 사업자번호

	@Column(name = "SUB_BIZ_PLACE_NO", length = 4)
	private String subBizPlaceNo; // 종사업장번호

	@Column(name = "OWNER_NM", length = 30, nullable = false)
	private String ownerNm; // 대표자명

	@Column(name = "COMPANY_REGIST_NO", length = 13)
	private String companyRegistNo; // 법인등록번호

	@Column(name = "BIZ_PLACE_ZIP_NO", length = 6, nullable = false)
	private String bizPlaceZipNo; // 사업장우편번호(배송용 주소)

	@Column(name = "BIZ_PLACE_ADDR", length = 100, nullable = false)
	private String bizPlaceAddr; // 사업장주소(배송용 주소)

	@Column(name = "BIZ_PLACE_ADDR_DETAIL", length = 150, nullable = false)
	private String bizPlaceAddrDetail; // 사업장주소상세(배송용 주소)

	@Column(name = "BIZ_PLACE_LEGALDONG_CD", length = 10)
	private String bizPlaceLegalDongCd; // 법정동/법정리코드(배송용 주소)

	/* ============ <flag변수> ============ */
	@Transient @Default
	private boolean isChangeUnitPriceApply = false; // 적용거래등급코드 변경여부.

	@Transient @Default
	private boolean isChangeApplyTradeGradeCd = false; // 단가적용코드 변경여부.
}