package com.cts.review.model;

public class Product {
    
	private int productId;
	
	private String productName;

	private String productReview;

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

	public Product(int productId, String productName, String productReview, int productRating) {
		this.productId = productId;
		this.productName = productName;
		this.productReview = productReview;
		this.productRating = productRating;
	}
}