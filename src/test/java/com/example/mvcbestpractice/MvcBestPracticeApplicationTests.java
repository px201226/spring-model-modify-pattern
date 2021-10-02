package com.example.mvcbestpractice;

import com.example.mvcbestpractice.entity.BizCust;
import com.example.mvcbestpractice.entity.QBizCust;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MvcBestPracticeApplicationTests {


	@Autowired EntityManager em;

	@Test
	void contextLoads() {

		BizCust bizCust = BizCust.entityBuilder().bizGroupNo(5L).bizCd("11").custCd(1).build();
		em.persist(bizCust);

		JPAQueryFactory query = new JPAQueryFactory(em);

		QBizCust qBizCust = QBizCust.bizCust;

		List<BizCust> fetch = query.selectFrom(qBizCust).fetch();

	}

}
