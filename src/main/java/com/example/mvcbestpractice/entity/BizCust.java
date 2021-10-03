package com.example.mvcbestpractice.entity;

import com.example.mvcbestpractice.common.UseYn;
import com.sun.istack.NotNull;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Getter @Setter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(builderMethodName = "entityBuilder", toBuilder = true) @IdClass(BizCustId.class)
public class BizCust extends BaseEntity {

	@Id @Column(name = "BIZ_GROUP_NO")
	@EqualsAndHashCode.Include
	private Long bizGroupNo; // 사업그룹번호

	@Id @Column(name = "BIZ_CD", length = 5)
	@EqualsAndHashCode.Include
	private String bizCd; // 사업자코드

	@Id @Column(name = "CUST_CD")
	@EqualsAndHashCode.Include
	private Integer custCd; // 거래처코드

	@Column(name = "CUST_NM", length = 50)
	private String custNm; // 거래처명

	private boolean deleted;

	@Column(name = "DISPLAY_CUST_CD", length = 14)
	private String displayCustCd; // 노출거래처코드

	@Column(name = "SALES_EMPLOY_CD", length = 10)
	private Integer salesEmployCd; // e사원코드

	@Column(name = "DELIVERY_EMPLOY_CD", length = 10)
	private Integer deliveryEmployCd; // 배송사원코드

	@Column(name = "OWNER_TEL_NO", length = 20)
	private String ownerTelNo; // 대표전화번호

	@Column(name = "MARKETB_PAY_USE_YN", length = 1) @Enumerated(EnumType.STRING)
	private UseYn marketbPayUseYn; // 마켓봄결제사용여부 NOTE: 매입처일때 default N

	@Column(name = "MARKETB_PAY_CREDIT_CARD_YN", length = 1) @Enumerated(EnumType.STRING) @Default
	private UseYn marketbPayCreditCardYn = UseYn.N; // 마켓봄결제_신용카드여부

	@Column(name = "MARKETB_PAY_ACCOUNT_TRANSFER_YN", length = 1) @Enumerated(EnumType.STRING) @Default
	private UseYn marketbPayAccountTransferYn = UseYn.N; // 마켓봄결제_계좌이체여부

	@Column(name = "DELIVERY_GROUP_CD")
	private Integer deliveryGroupCd; // 배송그룹코드 NOTE: 매입처일때 default null

	@Column(name = "CUST_SECTION_CD")
	private Integer custSectionCd; // 거래처분류코드

	@Column(name = "APPLY_TRADE_GRADE_CD", length = 4)
	private String applyTradeGradeCd; // 적용거래등급코드

	@Column(name = "AGENCY_CUST_YN", length = 1) @Enumerated(EnumType.STRING)
	private UseYn agencyCustYn; // 대리점거래처여부 NOTE: 매입처일때 default N

	@Column(name = "HEAD_OFFICE_YN", length = 1) @Enumerated(EnumType.STRING) @NotNull
	@Default
	private UseYn headOfficeYn = UseYn.N; // 본사여부

	@Column(name = "BIZ_NM", length = 70)
	private String bizNm; // 사업자명

	@Column(name = "BIZ_NO", length = 10)
	private String bizNo; // 사업자번호

	@Column(name = "SUB_BIZ_PLACE_NO", length = 4)
	private String subBizPlaceNo; // 종사업장번호

	@Column(name = "OWNER_NM", length = 30)
	private String ownerNm; // 대표자명

	@Column(name = "COMPANY_REGIST_NO", length = 13)
	private String companyRegistNo; // 법인등록번호

	@Column(name = "BIZ_PLACE_ZIP_NO", length = 6)
	private String bizPlaceZipNo; // 사업장우편번호(배송용 주소)

	@Column(name = "BIZ_PLACE_ADDR", length = 100)
	private String bizPlaceAddr; // 사업장주소(배송용 주소)

	@Column(name = "BIZ_PLACE_ADDR_DETAIL", length = 150)
	private String bizPlaceAddrDetail; // 사업장주소상세(배송용 주소)

	@Column(name = "BIZ_PLACE_LEGALDONG_CD", length = 10)
	private String bizPlaceLegalDongCd; // 법정동/법정리코드(배송용 주소)


	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL) // OneToOne
	@JoinColumn(name = "BIZ_GROUP_NO", referencedColumnName = "BIZ_GROUP_NO", insertable = false, updatable = false)
	@JoinColumn(name = "BIZ_CD", referencedColumnName = "BIZ_CD", insertable = false, updatable = false)
	@JoinColumn(name = "CUST_CD", referencedColumnName = "CUST_CD", insertable = false, updatable = false)
	private BizCustDtl bizCustDtl;

}