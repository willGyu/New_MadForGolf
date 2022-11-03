package com.madforgolf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.madforgolf.domain.ProductSellerVO;
import com.madforgolf.service.ProductSellerService;

@Controller
@RequestMapping("/product/*")
public class ProductSellerController {

	private static final Logger log = LoggerFactory.getLogger(ProductSellerController.class);

	@Autowired
	private ProductSellerService productSellerService;

	@RequestMapping(value="/seller", method = RequestMethod.GET)
	public String sellerView(@RequestParam("prod_num") Integer prodNum, ProductSellerVO productSellerVO, Model model)
			throws Exception {

		productSellerVO.setProd_num(prodNum);
		ProductSellerVO sellerInfo = productSellerService.selectSellerInfo(productSellerVO);
		model.addAttribute("sellerInfo", sellerInfo);
		return "/product_seller/seller_view";
	}

}
