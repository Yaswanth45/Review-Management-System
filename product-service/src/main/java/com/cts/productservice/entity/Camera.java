package com.cts.productservice.entity;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Camera")
@ApiModel(description = "This is a Camera Model")
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cId")
    @ApiModelProperty(value = "This is unique for every Camera")
    private int cameraId;
    
    @Column(name="resolution")
    @ApiModelProperty(value = "How much resolution the camera contains")
    private int resolution;

    @ManyToOne
    @ApiModelProperty(value = "Product Id will come here as a Foriegn/Parent")
    @JoinColumn(name = "pId")
    private Product product;

    @Column(name = "reviewText")
    @ApiModelProperty(value = "Review for the Camera")
    private String cameraReviewText;

    @Column(name = "stars")
    @ApiModelProperty(value = "Rating for the Camera")
    private int cameraRating;

    public int getCameraId() {
        return cameraId;
    }

    public void setCameraId(int cameraId) {
        this.cameraId = cameraId;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCameraReviewText() {
        return cameraReviewText;
    }

    public void setCameraReviewText(String cameraReviewText) {
        this.cameraReviewText = cameraReviewText;
    }

    public int getCameraRating() {
        return cameraRating;
    }

    public void setCameraRating(int cameraRating) {
        this.cameraRating = cameraRating;
    }


}