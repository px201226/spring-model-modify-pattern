package com.example.mvcbestpractice;

import com.example.mvcbestpractice.repository.BizCustDtlRepository;
import com.example.mvcbestpractice.repository.BizCustRepository;
import javax.persistence.EntityManager;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ApplicationInitializerTest {

	@Autowired BizCustRepository bizCustRepository;
	@Autowired BizCustDtlRepository bizCustDtlRepository;
	@Autowired EntityManager entityManager;
	@Autowired SessionFactory sessionFactory;

	@Test
	@DisplayName("dd")
	void a() {

		Session session = entityManager.unwrap(Session.class);
		Filter filter = session.enableFilter("deletedProductFilter");
		filter.setParameter("isDeleted", false);
		var employees = session.createQuery("from BizCust ").getResultList();
		System.out.println("dd");
//		Optional<BizCust> byId = bizCustRepository.findById(new BizCustId(1L, "00001", 1));
		session.disableFilter("deletedProductFilter");
	}
}