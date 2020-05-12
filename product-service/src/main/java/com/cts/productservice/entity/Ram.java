package com.cts.productservice.entity;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "Ram")
@ApiModel(description = "This is a Ram Model")
public class Ram {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rId")
	@ApiModelProperty(value = "This is unique for every Ram size")
	private int ramId;
	
	@Column(name="ram_size")
	@ApiModelProperty(value = "Sizes of Ram for every Product")
	private int ramSize;
	
	@ManyToOne
	@ApiModelProperty(value = "Products Id will come here")
	@JoinColumn(name = "pId")
	private Product product;
	
	@Column(name = "review_text")
	@ApiModelProperty(value = "Review for the Ram")
	private String ramReview;

	@Column(name = "stars")
	@ApiModelProperty(value = "Rating for the Ram")
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