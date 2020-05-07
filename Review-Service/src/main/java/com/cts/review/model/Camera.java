package com.cts.review.model;

public class Camera {

    private int cameraId;
        
    private int resolution;

    private Product product;

    private String cameraReviewText;

    private String cameraRating;

    public Camera(){
        super();
    }

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

    public String getCameraRating() {
        return cameraRating;
    }

    public void setCameraRating(String cameraRating) {
        this.cameraRating = cameraRating;
    }

}