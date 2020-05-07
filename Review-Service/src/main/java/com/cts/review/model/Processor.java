package com.cts.review.model;

public class Processor {

    private int processorId;

   
    private String processorName;

    private Product product;

    private String processorReview;

    private int processorRating;

    public Processor(){
        super();
    }

    public int getProcessorId() {
        return processorId;
    }

    public void setProcessorId(int processorId) {
        this.processorId = processorId;
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProcessorReview() {
        return processorReview;
    }

    public void setProcessorReview(String processorReview) {
        this.processorReview = processorReview;
    }

    public int getProcessorRating() {
        return processorRating;
    }

    public void setProcessorRating(int processorRating) {
        this.processorRating = processorRating;
    }

}