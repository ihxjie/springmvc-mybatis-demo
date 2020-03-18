package com.ex.model;

import java.math.BigDecimal;

public class Product {
    private Integer productId;

    private String productName;

    private BigDecimal productOriginalPrice;

    private BigDecimal productCurrentPrice;

    private Integer productStock;

    private String productPicture;

    private Integer typeId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public BigDecimal getProductOriginalPrice() {
        return productOriginalPrice;
    }

    public void setProductOriginalPrice(BigDecimal productOriginalPrice) {
        this.productOriginalPrice = productOriginalPrice;
    }

    public BigDecimal getProductCurrentPrice() {
        return productCurrentPrice;
    }

    public void setProductCurrentPrice(BigDecimal productCurrentPrice) {
        this.productCurrentPrice = productCurrentPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture == null ? null : productPicture.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productOriginalPrice=" + productOriginalPrice +
                ", productCurrentPrice=" + productCurrentPrice +
                ", productStock=" + productStock +
                ", productPicture='" + productPicture + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}