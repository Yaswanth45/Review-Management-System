package com.cts.productservice.model;


public class Battery {

    private int batteryId;

    private String capacity;

    private Product product;

    private String batteryReviewText;

    private int batteryRating;

    public Battery(){
        super();
    }

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

    public Battery(int batteryId, String capacity, Product product, String batteryReviewText, int batteryRating) {
        this.batteryId = batteryId;
        this.capacity = capacity;
        this.product = product;
        this.batteryReviewText = batteryReviewText;
        this.batteryRating = batteryRating;
    }

}