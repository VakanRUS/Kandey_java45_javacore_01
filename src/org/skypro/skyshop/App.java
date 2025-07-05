package org.skypro.skyshop;

import org.skypro.skyshop.Exceptions.BestResultNotFound;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.tools.SearchEngine;
import org.skypro.skyshop.tools.Searchable;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class App {
    public static void main(String[] args) throws BestResultNotFound {

        Basket basket = new Basket();
        SearchEngine search = new SearchEngine();

        SimpleProduct product1 = new SimpleProduct("Вишня", 100);
        FixPriceProduct product2 = new FixPriceProduct("Яблоки");
        DiscountedProduct product3 = new DiscountedProduct("Картошка", 60, 15);
        FixPriceProduct product4 = new FixPriceProduct("Молоко");
        DiscountedProduct product5 = new DiscountedProduct("Хлеб \"Бородинский\"", 40, 15);
        SimpleProduct product6 = new SimpleProduct("Сок \"Мультифрукт\"", 240);
        DiscountedProduct product7 = new DiscountedProduct("Масло", 200, 30);
        FixPriceProduct product8 = new FixPriceProduct("Хлеб \"Сендвичный\"");

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);
        basket.addProduct(product7);
        basket.addProduct(product8);

        search.addSearchable(product8);
        search.addSearchable(product7);
        search.addSearchable(product5);

        System.out.println("\n***\n");

        basket.printBasket();

        System.out.println("\n***\n");

        basket.findExistence("Соль");
        basket.findExistence("Test");

        System.out.println("\n***\n");

        basket.deleteItem("хлеб");
        basket.deleteItem("хлеб");

        basket.printBasket();

        System.out.println("\n***\n");

        System.out.println(search.search("Хлеб"));
    }
}