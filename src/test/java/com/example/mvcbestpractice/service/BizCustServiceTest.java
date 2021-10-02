package com.example.mvcbestpractice.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.mvcbestpractice.ApplicationInitializer;
import com.example.mvcbestpractice.controller.dto.BizCustDto;
import com.example.mvcbestpractice.controller.dto.BizCustSearchCondition;
import com.example.mvcbestpractice.controller.dto.BizCustWithDtlDto;
import com.example.mvcbestpractice.entity.BizCustId;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BizCustServiceTest {

	@Autowired
	BizCustService bizCustService;

	@Autowired
	ApplicationInitializer applicationInitializer;

	@Test
	@DisplayName("거래처 다건 필터링 조회")
	void findAllWithCondition() {

		// given
		Long bizGroupNo = 1L;
		BizCustSearchCondition condition = BizCustSearchCondition.builder()
				.bizCd("00001")
				.build();
		Long expect = applicationInitializer.bizCusts.stream().filter(e -> e.getBizGroupNo().equals(bizGroupNo) && e.getBizCd().equals("00001")).count();

		// when
		List<BizCustDto> all = bizCustService.findAll(1L, condition);

		// then
		assertThat(Long.valueOf(all.size())).isEqualTo(expect);
	}


	@Test
	@DisplayName("거래처 상세 조회")
	void test2() {

		// given
		BizCustId bizCustId = new BizCustId(1L, "00001", 1);

		// when
		List<BizCustWithDtlDto> result = bizCustService.findByIdWithDtl(bizCustId);

		// then
		assertThat(result.size()).isEqualTo(1);
	}


	@Test
	@DisplayName("채번 테스트")
	void test3() {

		assertEquals(bizCustService.nextCustCd(1L, "00001"), 5);

		assertEquals(bizCustService.nextCustCd(4L, "00001"), 1);

	}
}