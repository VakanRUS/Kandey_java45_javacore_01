package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    static final int FIXED_PRICE = 50;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public String toString() {
        return productName + ": Фиксированная цена " + FIXED_PRICE;
    }
}