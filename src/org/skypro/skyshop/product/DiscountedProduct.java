package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int discountPercent = 15;
    private int discountPrice;

    public DiscountedProduct(String productName, int productPrice) {
        super(productName, productPrice);
        discountPrice = productPrice - ((productPrice * discountPercent) / 100);
    }


    @Override
    public boolean isSpecial() {
        boolean isSpecial = true;
        return isSpecial;
    }

    @Override
    public int getPrice() {
        return discountPrice;
    }

    @Override
    public String toString() {
        return productName + " со скидкой: " + discountPrice + " (" + discountPercent + "%)";
    }
}