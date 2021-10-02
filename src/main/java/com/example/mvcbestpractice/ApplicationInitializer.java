package com.example.mvcbestpractice;


import com.example.mvcbestpractice.common.RowStatusCode;
import com.example.mvcbestpractice.entity.BizCust;
import com.example.mvcbestpractice.entity.BizCustDtl;
import com.example.mvcbestpractice.repository.BizCustDtlRepository;
import com.example.mvcbestpractice.repository.BizCustRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializer implements ApplicationRunner {


	public List<BizCustDtl> bizCustDtls = List.of(
			BizCustDtl.entityBuilder().bizGroupNo(1L).bizCd("00001").custCd(1).rowStsCd(RowStatusCode.U).build(),
			BizCustDtl.entityBuilder().bizGroupNo(1L).bizCd("00001").custCd(2).rowStsCd(RowStatusCode.U).build(),
			BizCustDtl.entityBuilder().bizGroupNo(1L).bizCd("00001").custCd(3).rowStsCd(RowStatusCode.U).build(),
			BizCustDtl.entityBuilder().bizGroupNo(1L).bizCd("00001").custCd(4).rowStsCd(RowStatusCode.D).build(),
			BizCustDtl.entityBuilder().bizGroupNo(1L).bizCd("00002").custCd(1).rowStsCd(RowStatusCode.U).build(),
			BizCustDtl.entityBuilder().bizGroupNo(1L).bizCd("00002").custCd(2).rowStsCd(RowStatusCode.U).build(),
			BizCustDtl.entityBuilder().bizGroupNo(1L).bizCd("00002").custCd(3).rowStsCd(RowStatusCode.U).build(),
			BizCustDtl.entityBuilder().bizGroupNo(1L).bizCd("00002").custCd(4).rowStsCd(RowStatusCode.D).build(),
			BizCustDtl.entityBuilder().bizGroupNo(1L).bizCd("00003").custCd(1).rowStsCd(RowStatusCode.U).build(),
			BizCustDtl.entityBuilder().bizGroupNo(1L).bizCd("00003").custCd(2).rowStsCd(RowStatusCode.U).build(),
			BizCustDtl.entityBuilder().bizGroupNo(1L).bizCd("00003").custCd(3).rowStsCd(RowStatusCode.U).build(),
			BizCustDtl.entityBuilder().bizGroupNo(1L).bizCd("00003").custCd(4).rowStsCd(RowStatusCode.D).build()
	);

	public List<BizCust> bizCusts = List.of(
			BizCust.entityBuilder().bizGroupNo(1L).bizCd("00001").custCd(1).bizCustDtl(bizCustDtls.get(0)).rowStsCd(RowStatusCode.U).build(),
			BizCust.entityBuilder().bizGroupNo(1L).bizCd("00001").custCd(2).bizCustDtl(bizCustDtls.get(1)).rowStsCd(RowStatusCode.U).build(),
			BizCust.entityBuilder().bizGroupNo(1L).bizCd("00001").custCd(3).bizCustDtl(bizCustDtls.get(2)).rowStsCd(RowStatusCode.U).build(),
			BizCust.entityBuilder().bizGroupNo(1L).bizCd("00001").custCd(4).bizCustDtl(bizCustDtls.get(3)).rowStsCd(RowStatusCode.D).build(),
			BizCust.entityBuilder().bizGroupNo(1L).bizCd("00002").custCd(1).bizCustDtl(bizCustDtls.get(4)).rowStsCd(RowStatusCode.U).build(),
			BizCust.entityBuilder().bizGroupNo(1L).bizCd("00002").custCd(2).bizCustDtl(bizCustDtls.get(5)).rowStsCd(RowStatusCode.U).build(),
			BizCust.entityBuilder().bizGroupNo(1L).bizCd("00002").custCd(3).bizCustDtl(bizCustDtls.get(6)).rowStsCd(RowStatusCode.U).build(),
			BizCust.entityBuilder().bizGroupNo(1L).bizCd("00002").custCd(4).bizCustDtl(bizCustDtls.get(7)).rowStsCd(RowStatusCode.D).build(),
			BizCust.entityBuilder().bizGroupNo(1L).bizCd("00003").custCd(1).bizCustDtl(bizCustDtls.get(8)).rowStsCd(RowStatusCode.U).build(),
			BizCust.entityBuilder().bizGroupNo(1L).bizCd("00003").custCd(2).bizCustDtl(bizCustDtls.get(9)).rowStsCd(RowStatusCode.U).build(),
			BizCust.entityBuilder().bizGroupNo(1L).bizCd("00003").custCd(3).bizCustDtl(bizCustDtls.get(10)).rowStsCd(RowStatusCode.U).build(),
			BizCust.entityBuilder().bizGroupNo(1L).bizCd("00003").custCd(4).bizCustDtl(bizCustDtls.get(11)).rowStsCd(RowStatusCode.D).build()
	);

	@Autowired private BizCustRepository bizCustRepository;
	@Autowired private BizCustDtlRepository bizCustDtlRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		bizCusts.get(3).setRowStsCd(RowStatusCode.D);
		bizCusts.get(7).setRowStsCd(RowStatusCode.D);
		bizCusts.get(11).setRowStsCd(RowStatusCode.D);

		bizCustRepository.saveAll(bizCusts);

	}


}
