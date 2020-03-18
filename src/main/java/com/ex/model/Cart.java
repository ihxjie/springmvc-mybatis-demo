package com.ex.model;

public class Cart {
    private Integer cartId;

    private String purchaseQuantity;

    private Integer userId;

    private Integer productId;

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
        this.purchaseQuantity = purchaseQuantity == null ? null : purchaseQuantity.trim();
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

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", purchaseQuantity='" + purchaseQuantity + '\'' +
                ", userId=" + userId +
                ", productId=" + productId +
                '}';
    }
}