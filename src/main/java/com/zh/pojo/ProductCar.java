package com.zh.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="product_car")
@Entity
public class ProductCar {
	
	/**
	 * 编号
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 *  商品id
	 */
	private Long proId;
	
}
