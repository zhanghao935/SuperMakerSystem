package com.zh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zh.pojo.ProductPo;
import com.zh.repository.ProductRepository;
import com.zh.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<ProductPo> findList() {
		return productRepository.findByDeleteState(0);
	}

	@Override
	public ProductPo save(ProductPo productPo) {
		return productRepository.save(productPo);
	}

	@Override
	public List<ProductPo> findByProductName(String productName) {
		return productRepository.findByProductNameAndDeleteState(productName, 0);
	}

	@Override
	public ProductPo findById(Long id) {
		return productRepository.findOne(id);
	}

	@Override
	public List<ProductPo> findByDeleteState(int i) {
		return productRepository.findByDeleteState(1);
	}

}
