package com.example.mvcbestpractice.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode
@AllArgsConstructor
public class BizCustId implements Serializable {

	@Id @Column(name = "BIZ_GROUP_NO", nullable = false)
	private Long bizGroupNo; // 사업그룹번호

	@Id @Column(name = "BIZ_CD", length = 5, nullable = false)
	private String bizCd; // 사업자코드

	@Id @Column(name = "CUST_CD", nullable = false)
	private Integer custCd; // 거래처코드

	@Override
	public String toString() {
		return "BizCustId{" +
				"bizGroupNo=" + bizGroupNo +
				", bizCd='" + bizCd + '\'' +
				", custCd=" + custCd +
				'}';
	}
}
