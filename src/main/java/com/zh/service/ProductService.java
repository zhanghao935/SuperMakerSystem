package com.zh.service;

import java.util.List;

import com.zh.pojo.ProductPo;

public interface ProductService {
	
	/**
	 * 商品列表
	 * @return	所有商品数据
	 */
	List<ProductPo> findList();
	
	/**
	 * 添加商品
	 * @param productPo	商品参数
	 * @return	db商品
	 */
	ProductPo save(ProductPo productPo);
	
	/**
	 * 
	 * @param productName
	 * @return
	 */
	List<ProductPo> findByProductName(String productName);
	
	/**
	 * 
	 * @param id
	 */
	ProductPo findById(Long id);
	
	/**
	 * 
	 * @param i
	 */
	List<ProductPo> findByDeleteState(int i);

}
