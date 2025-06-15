package org.skypro.skyshop.product;

public abstract class Product {
    protected final String productName;
    protected static int checkIsBasketFull = 0;

    public Product(String productName, int productPrice) {
        this.productName = productName;
    }

    public boolean isSpecial(int checkIsSpecial) {
        boolean isSpecial = false;
        if (checkIsSpecial != 0) {
            isSpecial = true;
        }
        return isSpecial;
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

    public abstract int getPrice();

    public abstract boolean isSpecial();
}