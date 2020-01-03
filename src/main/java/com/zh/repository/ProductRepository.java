package com.zh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zh.pojo.ProductPo;

@Repository
public interface ProductRepository extends JpaRepository<ProductPo, Long>{

	List<ProductPo> findByProductName(String productName);

	List<ProductPo> findByDeleteState(int i);

	List<ProductPo> findByProductNameAndDeleteState(String productName, int i);

}
