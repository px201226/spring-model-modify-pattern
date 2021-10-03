package com.example.mvcbestpractice.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBizCustDto {

	private Long bizGroupNo;
	private String bizCd;
	private Integer custCd;
	private String custNm; // 거래처명
	private String etcTelNo1; // 기타전화번호1

}
