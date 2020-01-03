package com.zh.pojo;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 商品Po
 * @author ZHANGHAO
 *
 */
@Table(name="product")
@Entity
public class ProductPo {
	
	/**
	 * 编号
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * 商品名称
	 */
	private String productName;
	
	/**
	 * 库存
	 */
	private Integer  productStock;
	
	/**
	 * 进价
	 */
	private Integer purchasePrice;
	
	/**
	 * 售价
	 */
	private Integer price;
	
	/**
	 * 删除状态
	 */
	private Integer deleteState;
	
	/**
	 * 生产日期
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd")
	private Date createTime;
	
	/**
	 * 结束日期
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd")
	private Date endTime;

	@Transient
	private String isExprie;
		
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductStock() {
		return productStock;
	}

	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}

	public Integer getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Integer purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getDeleteState() {
		return deleteState;
	}

	public void setDeleteState(Integer deleteState) {
		this.deleteState = deleteState;
	}

	public String getIsExprie() {
		return isExprie;
	}

	public void setIsExprie(String isExprie) {
		this.isExprie = isExprie;
	}
	
	
	
}
