package com.example.mvcbestpractice.repository;

import com.example.mvcbestpractice.controller.dto.BizCustDto;
import com.example.mvcbestpractice.controller.dto.BizCustSearchCondition;
import com.example.mvcbestpractice.controller.dto.BizCustWithDtlDto;
import com.example.mvcbestpractice.entity.BizCustId;
import java.util.List;

public interface BizCustRepositoryCustom {


	List<BizCustDto> findAll(Long bizGroupNo, BizCustSearchCondition condition);

	List<BizCustWithDtlDto> findByIdWithDtl(BizCustId bizCustId);
}
