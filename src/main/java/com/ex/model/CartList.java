package com.ex.model;

import java.math.BigDecimal;

public class CartList {
    private Integer cartId;

    private String purchaseQuantity;

    private Integer userId;

    private Integer productId;

    private String productName;

    private BigDecimal productOriginalPrice;

    private BigDecimal productCurrentPrice;

    private Integer productStock;

    private String productPicture;

    private Integer typeId;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(String purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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
        this.productName = productName;
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
        this.productPicture = productPicture;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "CartList{" +
                "cartId=" + cartId +
                ", purchaseQuantity='" + purchaseQuantity + '\'' +
                ", userId=" + userId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productOriginalPrice=" + productOriginalPrice +
                ", productCurrentPrice=" + productCurrentPrice +
                ", productStock=" + productStock +
                ", productPicture='" + productPicture + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}
