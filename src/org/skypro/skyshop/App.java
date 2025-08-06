package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.productBasket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.tools.SearchEngine;
import org.skypro.skyshop.tools.Searchable;

public class App {
    public static SearchEngine search = new SearchEngine();
    public static Basket basket = new Basket();

    public static void main(String[] args) throws BestResultNotFound {
        Searchable[] found;
        SearchEngine search = new SearchEngine(10);
        String searchTerm;

        ProductBasket productBasket = new ProductBasket();

        SimpleProduct product1 = new SimpleProduct("Вишня", 100);

        DiscountedProduct product3 = new DiscountedProduct("Картошка", 60, 15);
        FixPriceProduct product4 = new FixPriceProduct("Молоко");
        DiscountedProduct product5 = new DiscountedProduct("Хлеб \"Бородинский\"", 40, 15);
        SimpleProduct product6 = new SimpleProduct("Сок \"Мультифрукт\"", 240);
        DiscountedProduct product7 = new DiscountedProduct("Масло", 200, 30);
        FixPriceProduct product8 = new FixPriceProduct("Хлеб \"Белый\"");

        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product5);
        productBasket.addProduct(product6);
        productBasket.addProduct(product7);
        productBasket.addProduct(product8);

        try {
            FixPriceProduct Product2 = new FixPriceProduct("");
            productBasket.addProduct(Product2);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Продукт не добавлен в корзину\n");
        }

        try {
            DiscountedProduct Product3 = new DiscountedProduct("Картошка", 120, 115);
            productBasket.addProduct(Product3);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Продукт не добавлен в корзину\n");
        }
        System.out.println("----\n");

        search.add(product1);
        search.add(product2);
        search.add(product3);
        search.add(product4);
        search.add(product5);
        search.add(product6);
        search.add(product7);
        search.add(product8);

        search.add(new Article("Кефира побольше!", "Кефир " + "Колбаса " + "Кефир " + "Батон " + "Кефир "));
        search.add(new Article("Типичный обед студента.", "Кефир " + "Сайка "));
        search.add(new Article("Рецепт окрошки на кефире.", "Кефир " + "Хлеб " + "Колбаса " + "Яйцо "));

        System.out.println("basket.findExistence(\"Хлеб \"Бородинский\"\") = " + productBasket.findExistence("Хлеб \"Бородинский\""));
        System.out.println("basket.findExistence(\"Test\") = " + productBasket.findExistence("Test"));

        System.out.println();

        searchTerm = "Кефир";
        System.out.println("search.searchBestResult(searchTerm) = " + search.searchBestResult(searchTerm));

        System.out.println();

        System.out.println("basket.deleteItem(\"Хлеб \"Сендвичный\"\") = " + productBasket.deleteItem("Хлеб \"Сендвичный\""));
        System.out.println("basket.deleteItem(\"Хлеб \") = " + productBasket.deleteItem("Хлеб"));
        System.out.println();
        productBasket.printBasket();

    }
}
