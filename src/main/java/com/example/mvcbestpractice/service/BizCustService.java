package com.example.mvcbestpractice.service;


import com.example.mvcbestpractice.controller.dto.BizCustDto;
import com.example.mvcbestpractice.controller.dto.BizCustSearchCondition;
import com.example.mvcbestpractice.controller.dto.BizCustWithDtlDto;
import com.example.mvcbestpractice.controller.dto.UpdateBizCustDto;
import com.example.mvcbestpractice.controller.mapper.BizCustMapper;
import com.example.mvcbestpractice.entity.BizCust;
import com.example.mvcbestpractice.entity.BizCustId;
import com.example.mvcbestpractice.repository.BizCustRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BizCustService {

	private final BizCustRepository bizCustRepository;
	private final BizCustMapper mapper;
	private final EntityManager entityManager;


	public List<BizCustDto> findAll(Long bizGroupNo, BizCustSearchCondition condition) {
		return bizCustRepository.findAll(bizGroupNo, condition);
	}

	public List<BizCustWithDtlDto> findByIdWithDtl(BizCustId bizCustId) {
		return bizCustRepository.findByIdWithDtl(bizCustId);
	}


	/**
	 * 채번용 메서드
	 * @param bizGroupNo
	 * @param bizCd
	 * @return
	 */
	public Integer nextCustCd(Long bizGroupNo, String bizCd) {

		Optional<BizCust> find = bizCustRepository.findTopByBizGroupNoAndBizCdOrderByCustCdDesc(bizGroupNo, bizCd);

		if (find.isEmpty()) {
			return 1;
		} else {
			return find.get().getCustCd() + 1;
		}
	}


	public BizCust update(UpdateBizCustDto dto) {
		BizCust entity = bizCustRepository.findById(new BizCustId(dto.getBizGroupNo(), dto.getBizCd(), dto.getCustCd())).get();
		mapper.updateBizCustDtoToBizCust(dto, entity);
		return bizCustRepository.save(entity);
	}

	public List<BizCust> findById(List<BizCustId> bizCustIds) {
		return bizCustRepository.findAllById(bizCustIds);
	}
}
