package com.cts.productservice.entity;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Processor")
@ApiModel(description = "This is a Processor Model")
public class Processor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prId")
    @ApiModelProperty(value = "This is unique for every Processor type")
    private int processorId;

    @Column(name="prName")
    @ApiModelProperty(value = "Name of the Processor")
    private String processorName;

    @ManyToOne
    @ApiModelProperty(value = "Products Id will come here ")
    @JoinColumn(name = "pId")
    private Product product;

    @Column(name = "reviewText")
    @ApiModelProperty(value = "Review for the Processor")
    private String processorReview;

    @Column(name = "stars")
    @ApiModelProperty(value = "Rating for the Processor")
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

    public Processor(int processorId, String processorName, Product product, String processorReview,
            int processorRating) {
        this.processorId = processorId;
        this.processorName = processorName;
        this.product = product;
        this.processorReview = processorReview;
        this.processorRating = processorRating;
    }

}