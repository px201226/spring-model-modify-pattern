package com.example.mvcbestpractice.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.mvcbestpractice.entity.BizCust;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BizCustRepositoryTest {

	@Autowired BizCustRepository bizCustRepository;

	@Test
	@DisplayName("Spring data jpa 메서드 채번되나")
	void test1() {
		Optional<BizCust> maxBizCust = bizCustRepository.findTopByBizGroupNoAndBizCdOrderByCustCdDesc(1L, "00001");

		assertEquals(maxBizCust.isPresent(), true);
		assertEquals(maxBizCust.get().getCustCd(), 4);
	}
}