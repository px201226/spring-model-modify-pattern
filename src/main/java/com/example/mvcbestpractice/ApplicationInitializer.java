package com.example.mvcbestpractice;


import com.example.mvcbestpractice.common.RowStatusCode;
import com.example.mvcbestpractice.entity.BizCust;
import com.example.mvcbestpractice.repository.BizCustDtlRepository;
import com.example.mvcbestpractice.repository.BizCustRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializer implements ApplicationRunner {

	@Autowired private BizCustRepository bizCustRepository;
	@Autowired private BizCustDtlRepository bizCustDtlRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("dd");
		List<BizCust> bizCusts = List.of(
				BizCust.entityBuilder().bizGroupNo(1L).bizCd("00001").custCd(1).build(),
				BizCust.entityBuilder().bizGroupNo(1L).bizCd("00001").custCd(2).build(),
				BizCust.entityBuilder().bizGroupNo(1L).bizCd("00001").custCd(3).build(),
				BizCust.entityBuilder().bizGroupNo(1L).bizCd("00001").custCd(4).build(),
				BizCust.entityBuilder().bizGroupNo(1L).bizCd("00001").custCd(5).build(),
				BizCust.entityBuilder().bizGroupNo(1L).bizCd("00001").custCd(6).build(),
				BizCust.entityBuilder().bizGroupNo(1L).bizCd("00002").custCd(1).build(),
				BizCust.entityBuilder().bizGroupNo(1L).bizCd("00002").custCd(2).build(),
				BizCust.entityBuilder().bizGroupNo(2L).bizCd("00002").custCd(3).build(),
				BizCust.entityBuilder().bizGroupNo(2L).bizCd("00003").custCd(1).build(),
				BizCust.entityBuilder().bizGroupNo(2L).bizCd("00003").custCd(2).build(),
				BizCust.entityBuilder().bizGroupNo(2L).bizCd("00003").custCd(3).build(),
				BizCust.entityBuilder().bizGroupNo(2L).bizCd("00003").custCd(4).build()
		);
		bizCusts.get(0).setRowStsCd(RowStatusCode.D);
		bizCusts.get(1).setRowStsCd(RowStatusCode.D);
		bizCusts.get(2).setRowStsCd(RowStatusCode.D);
		bizCusts.get(3).setRowStsCd(RowStatusCode.D);

		bizCustRepository.saveAll(bizCusts);
	}


}
