package com.cts.productservice.model;


public class Display {
 
    private int displayId;

    private float inches;

    private Product product;

    private String displayReview;

    private int displayRating;

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

}