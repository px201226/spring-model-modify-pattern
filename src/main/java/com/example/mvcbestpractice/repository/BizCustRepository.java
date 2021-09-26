package com.example.mvcbestpractice.repository;

import com.example.mvcbestpractice.entity.BizCust;
import com.example.mvcbestpractice.entity.BizCustId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BizCustRepository extends JpaRepository<BizCust, BizCustId> {


}
