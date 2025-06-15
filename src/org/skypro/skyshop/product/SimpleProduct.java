package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    static int simplePrice = 0;

    public SimpleProduct(String productName, int productPrice) {
        super(productName, productPrice);
        SimpleProduct.simplePrice = productPrice;
    }

    @Override
    public int getPrice() {
        return simplePrice;
    }

    @Override
    public boolean isSpecial() {
        boolean isSpecial = false;
        return isSpecial;
    }

    @Override
    public String toString() {
        return productName + ": " + simplePrice;
    }
}
