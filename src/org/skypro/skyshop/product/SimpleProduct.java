package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int simplePrice;

    public SimpleProduct(String name, int price) {
        super(name);
        simplePrice = price;
    }

    @Override
    public int getPrice() {
        return simplePrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ": " + simplePrice;
    }
}