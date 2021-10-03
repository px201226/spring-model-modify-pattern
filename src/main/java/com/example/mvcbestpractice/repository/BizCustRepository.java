package com.example.mvcbestpractice.repository;

import com.example.mvcbestpractice.entity.BizCust;
import com.example.mvcbestpractice.entity.BizCustId;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BizCustRepository extends JpaRepository<BizCust, BizCustId>, QuerydslPredicateExecutor<BizCust>, BizCustRepositoryCustom {

	List<BizCust> findAll(Specification specification);

	List<BizCust> findByBizGroupNo(Long bizGroupNo);

	Optional<BizCust> findTopByBizGroupNoAndBizCdOrderByCustCdDesc(Long bizGroupNo, String bizCd);


}

