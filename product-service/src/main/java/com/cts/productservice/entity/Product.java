package com.cts.productservice.entity;

import javax.persistence.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name="Product")
@ApiModel(description = "This is the Product model" )
public class Product {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pId")
	@ApiModelProperty(value = "A unique for each product")
	private int productId;
	
	@Column(name="pName")
	@ApiModelProperty(value="Name of the product")
	private String productName;

	@Column(name = "reviewText")
	@ApiModelProperty(value="Review for the Product")
	private String productReview;

	@Column(name = "stars")
	@ApiModelProperty(value="Rating for the product")
	private int productRating;
	
	public Product() {
		super();
	}
	
	public Product(int productId) {
		super();
		this.productId=productId;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductReview() {
		return productReview;
	}

	public void setProductReview(String productReview) {
		this.productReview = productReview;
	}

	public int getProductRating() {
		return productRating;
	}

	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}
}