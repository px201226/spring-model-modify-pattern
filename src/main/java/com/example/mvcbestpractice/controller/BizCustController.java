package com.example.mvcbestpractice.controller;


import com.example.mvcbestpractice.service.BizCustService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BizCustController {

	private final BizCustService bizCustService;


}
