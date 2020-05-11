package com.cts.productservice.model;


public class Ram {
 
	private int ramId;

	private int ramSize;

	private Product product;

	private String ramReview;

	private int ramRating;

	public int getRamId() {
		return ramId;
	}

	public void setRamId(int ramId) {
		this.ramId = ramId;
	}

	public int getRamSize() {
		return ramSize;
	}

	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getRamReview() {
		return ramReview;
	}

	public void setRamReview(String ramReview) {
		this.ramReview = ramReview;
	}

	public int getRamRating() {
		return ramRating;
	}

	public void setRamRating(int ramRating) {
		this.ramRating = ramRating;
	}

	public Ram(int ramId, int ramSize, Product product, String ramReview, int ramRating) {
		this.ramId = ramId;
		this.ramSize = ramSize;
		this.product = product;
		this.ramReview = ramReview;
		this.ramRating = ramRating;
	}

}