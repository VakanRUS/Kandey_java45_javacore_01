package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    public static int getPrice;
    private final int FIXED_PRICE = 50;

    public FixPriceProduct(String productName, int productPrice) {
        super(productName, productPrice);
    }

    @Override
    public boolean isSpecial() {
        boolean isSpecial = true;
        return isSpecial;
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
