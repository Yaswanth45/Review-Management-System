package com.cts.productservice.entity;

import javax.persistence.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "Display")
@ApiModel(description = "This is a Display Model")
public class Display {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dId")
    @ApiModelProperty(value = "This is unique for every Display type")
    private int displayId;

    @Column(name="inches")
    @ApiModelProperty(value = "It will tell how many inches the display contains")
    private float inches;

    @ManyToOne
    @ApiModelProperty(value = "Products ID will come here")
    @JoinColumn(name = "pId")
    private Product product;

    @Column(name="review_text")
    @ApiModelProperty(value = "Review for the Display")
    private String displayReview;

    @Column(name="stars")
    @ApiModelProperty(value = "Rating for the Display")
    private int displayRating;

    public Display(){
        super();
    }

    public int getDisplayId() {
        return displayId;
    }

    public void setDisplayId(int displayId) {
        this.displayId = displayId;
    }

    public float getInches() {
        return inches;
    }

    public void setInches(float inches) {
        this.inches = inches;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDisplayReview() {
        return displayReview;
    }

    public void setDisplayReview(String displayReview) {
        this.displayReview = displayReview;
    }

    public int getDisplayRating() {
        return displayRating;
    }

    public void setDisplayRating(int displayRating) {
        this.displayRating = displayRating;
    }

    public Display(int displayId, float inches, Product product, String displayReview, int displayRating) {
        this.displayId = displayId;
        this.inches = inches;
        this.product = product;
        this.displayReview = displayReview;
        this.displayRating = displayRating;
    }

}