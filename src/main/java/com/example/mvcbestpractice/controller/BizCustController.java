package com.example.mvcbestpractice.controller;


import com.example.mvcbestpractice.entity.BizCust;
import com.example.mvcbestpractice.service.BizCustService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BizCustController {

	private final BizCustService bizCustService;

	@GetMapping("/1")
	public Integer get() {
		List<BizCust> all = bizCustService.findAll();
		System.out.println("결과");
		System.out.println(all.size());
		return all.size();
	}


	@GetMapping("/2")
	public Integer get2() {
		List<BizCust> all = bizCustService.findAll2();
		System.out.println("결과");
		System.out.println(all.size());
		return all.size();
	}
}
