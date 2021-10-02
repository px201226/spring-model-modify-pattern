package com.example.mvcbestpractice.repository;

import static org.assertj.core.api.Assertions.*;

import com.example.mvcbestpractice.ApplicationInitializer;
import com.example.mvcbestpractice.common.RowStatusCode;
import com.example.mvcbestpractice.entity.BizCust;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class RowStatusSpecificationTest {

	@Autowired BizCustRepository bizCustRepository;
	@Autowired ApplicationInitializer applicationInitializer;

	@Test
	@DisplayName("소프트 딜리트 전체조회")
	void test1() {

		List<BizCust> all = bizCustRepository.findAll();

		assertThat(all.size()).isEqualTo(applicationInitializer.bizCusts.size());
	}


	@Test
	@DisplayName("소프트 딜리트 삭제되지 않은 상태")
	void test2() {

		List<BizCust> all = bizCustRepository.findAll(RowStatusSpecification.inActiveStatus());

		System.out.println(all.size());
		assertThat(all.size()).isEqualTo(applicationInitializer.bizCusts.stream().filter(a -> a.getRowStsCd().equals(RowStatusCode.U)).count());
	}

}