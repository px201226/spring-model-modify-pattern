package com.example.mvcbestpractice.entity;

import com.example.mvcbestpractice.common.LocalDateAttributeConverter;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Getter @Setter
@DynamicUpdate
//@Where(clause = "ROW_STS_CD = 'U'")
@NoArgsConstructor @AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder(builderMethodName = "entityBuilder", toBuilder = true) @IdClass(BizCustId.class)
public class BizCustDtl extends BaseEntity {


	@Id @Column(name = "BIZ_GROUP_NO", nullable = false)
	private Long bizGroupNo; // 사업그룹번호

	@Id @Column(name = "BIZ_CD", length = 5, nullable = false)
	private String bizCd; // 사업자코드

	@Id @Column(name = "CUST_CD", nullable = false)
	private Integer custCd; // 거래처코드

	@Column(name = "TRADE_END_DE", length = 8) @Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate tradeEndDe; // 거래종료일

	@Column(name = "TRADE_END_REASON", length = 200)
	private String tradeEndReason; // 거래종료사유

	@Column(name = "POSTAL_MATTER_ZIP_NO", length = 6)
	private String postalMatterZipNo; // 우편물우편번호(세금계산서용 주소)

	@Column(name = "POSTAL_MATTER_ADDR", length = 100)
	private String postalMatterAddr; // 우편물주소(세금계산서용 주소)

	@Column(name = "POSTAL_MATTER_ADDR_DETAIL", length = 150)
	private String postalMatterAddrDetail; // 우편물주소상세(세금계산서용 주소)

	@Column(name = "ETC_TEL_NO_1", length = 20)
	private String etcTelNo1; // 기타전화번호1

	@Column(name = "ETC_TEL_NO_2", length = 20)
	private String etcTelNo2; // 기타전화번호2

	@Column(name = "ETC_TEL_NO_3", length = 20)
	private String etcTelNo3; // 기타전화번호3

	@Column(name = "ADD_BANK_CD", length = 5)
	private String addBankCd; // 추가은행코드

	@Column(name = "ADD_ACCOUNT_NO", length = 20)
	private String addAccountNo; // 추가계좌번호

	@Column(name = "ADD_DEPOSITOR_NM", length = 20)
	private String addDepositorNm; // 추가예금주명

	@Column(name = "GRANTEE_TYPE_CD", length = 10)
	private String granteeTypeCd; // 양수자유형코드

	@Column(name = "MEMO_MATTER", length = 30)
	private String memoMatter; // 메모사항

	@Column(name = "MEMO_REASON", length = 200)
	private String memoReason; // 메모사유

}