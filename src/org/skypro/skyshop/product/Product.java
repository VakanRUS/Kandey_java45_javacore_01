package org.skypro.skyshop.product;

public class Product {
    private final String productName;
    private final int productPrice;
    private static int checkIsBasketFull = 0;

    public Product(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public static int getCheckIsBasketFull() {
        return checkIsBasketFull;
    }

    public static void setCheckIsBasketFull(int checkIsBasketFull) {
        Product.checkIsBasketFull = checkIsBasketFull;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }
}