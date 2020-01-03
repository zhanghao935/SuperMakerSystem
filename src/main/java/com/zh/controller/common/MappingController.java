package com.zh.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author ZHANGHAO
 *
 */
@Controller
public class MappingController {
	
	/**
	 * 首页列表
	 * @return
	 */
	@RequestMapping("index")
	public String index(){
		return "index/productIndex";
	}
	
	/**
	 * 添加商品
	 * @return
	 */
	@RequestMapping("addProduct")
	public String addProduct(){
		return "productAdd";
	}
	/**
	 * 商品
	 * @return
	 */
	@RequestMapping("productDetail")
	public String productDetail(){
		return "index/productDetail";
	}
	
}
