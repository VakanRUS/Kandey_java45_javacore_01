package org.skypro.skyshop.product;

import org.skypro.skyshop.tools.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя продукта не может быть пустым");
        } else this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isSpecial();

    public abstract int getPrice();

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }
}