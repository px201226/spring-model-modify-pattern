package com.example.mvcbestpractice.repository;

import com.example.mvcbestpractice.entity.BizCustDtl;
import com.example.mvcbestpractice.entity.BizCustId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BizCustDtlRepository extends JpaRepository<BizCustDtl, BizCustId> {

}
