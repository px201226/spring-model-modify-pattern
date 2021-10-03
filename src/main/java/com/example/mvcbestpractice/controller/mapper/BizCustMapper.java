package com.example.mvcbestpractice.controller.mapper;


import com.example.mvcbestpractice.controller.dto.UpdateBizCustDto;
import com.example.mvcbestpractice.entity.BizCust;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BizCustMapper {

	@Mappings({
			@Mapping(target = "bizGroupNo", source = "dto.bizGroupNo"),
			@Mapping(target = "bizCd", source = "dto.bizCd"),
			@Mapping(target = "custCd", source = "dto.custCd"),
			@Mapping(target = "custNm", source = "dto.custNm"),
			@Mapping(target = "bizCustDtl.etcTelNo1", source = "dto.etcTelNo1")
	})
	void updateBizCustDtoToBizCust(UpdateBizCustDto dto, @MappingTarget BizCust entity);
}
