package com.cts.productservice.model;

public class Camera {

    private int cameraId;
 
    private int resolution;

    private Product product;

    private String cameraReviewText;

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

    public Camera(int cameraId, int resolution, Product product, String cameraReviewText, int cameraRating) {
        this.cameraId = cameraId;
        this.resolution = resolution;
        this.product = product;
        this.cameraReviewText = cameraReviewText;
        this.cameraRating = cameraRating;
    }
}