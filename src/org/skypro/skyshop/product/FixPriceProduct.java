package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private final int FIXED_PRICE = 50;

    public FixPriceProduct(String name) {
        super(name);
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
        return getName() + ": Фиксированная цена " + FIXED_PRICE;
    }
}