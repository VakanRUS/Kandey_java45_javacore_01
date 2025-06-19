package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;

    public Product(String productName) {
        this.name = productName;
    }

    public boolean isSpecial() {
        return false;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();
}