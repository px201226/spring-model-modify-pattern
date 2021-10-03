package com.example.mvcbestpractice.repository;

import com.example.mvcbestpractice.controller.dto.BizCustDto;
import com.example.mvcbestpractice.controller.dto.BizCustSearchCondition;
import com.example.mvcbestpractice.controller.dto.BizCustWithDtlDto;
import com.example.mvcbestpractice.entity.BizCust;
import com.example.mvcbestpractice.entity.BizCustId;
import java.util.List;

interface BizCustRepositoryCustom {


	List<BizCustDto> findAll(Long bizGroupNo, BizCustSearchCondition condition);

	List<BizCustWithDtlDto> findByIdWithDtl(BizCustId bizCustId);

	void delete(Iterable<BizCustId> bizCustIds);

	List<BizCust> findAllById(Iterable<BizCustId> bizCustIds);
}
