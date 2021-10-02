package com.example.mvcbestpractice.controller.dto;


import com.example.mvcbestpractice.common.UseYn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class BizCustSearchCondition {

	String bizCd; // 소속 회사
	Integer custType; // 거래처 구분
	UseYn useYn; // 사용 여부
	String custName; // 거래처명
	Integer salesEmployCd; // 영업사원
	Integer deliveryEmployCd; // 배송담당

}
