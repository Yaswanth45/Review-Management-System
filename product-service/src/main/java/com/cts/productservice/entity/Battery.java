package com.cts.productservice.entity;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This is Battery Model")
@Entity
@Table(name = "Battery")
public class Battery {

    @ApiModelProperty(value = "This is unique for every Battery")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bId")
    private int batteryId;
    
    @ApiModelProperty(value = "Capacity of a Battery in mah")
    @Column(name="capacity")
    private String capacity;

    @ApiModelProperty(value = "The Product Id was getting here")
    @ManyToOne
    @JoinColumn(name = "pId")
    private Product product;

    @ApiModelProperty(value = "Review for the Battery")
    @Column(name="review_text")
    private String batteryReviewText;

    @ApiModelProperty(value = "Rating for the Battery")
    @Column(name = "stars")
    private int batteryRating;


    public int getBatteryId() {
        return batteryId;
    }

    public void setBatteryId(int batteryId) {
        this.batteryId = batteryId;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getBatteryReviewText() {
        return batteryReviewText;
    }

    public void setBatteryReviewText(String batteryReviewText) {
        this.batteryReviewText = batteryReviewText;
    }

    public int getBatteryRating() {
        return batteryRating;
    }

    public void setBatteryRating(int batteryRating) {
        this.batteryRating = batteryRating;
    }

}