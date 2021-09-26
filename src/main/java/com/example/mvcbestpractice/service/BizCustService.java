package com.example.mvcbestpractice.service;


import com.example.mvcbestpractice.entity.BizCust;
import com.example.mvcbestpractice.repository.BizCustRepository;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BizCustService {

	private final BizCustRepository bizCustRepository;
	private final EntityManager entityManager;

	public List<BizCust> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Filter filter = session.enableFilter("RowStatusFilter");
		filter.setParameter("rowStatusCode", "D");
		List<BizCust> bizCusts = bizCustRepository.findAll();
		session.disableFilter("RowStatusFilter");
		System.out.println("dddddddd");
		return bizCusts;
	}

	public List<BizCust> findAll2() {
		return bizCustRepository.findAll();
	}
}
