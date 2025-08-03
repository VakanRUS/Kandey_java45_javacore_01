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

public class App {
    public static SearchEngine search = new SearchEngine();
    public static Basket basket = new Basket();

    public static void main(String[] args) throws BestResultNotFound {
        Searchable[] found;
        SearchEngine search = new SearchEngine(10);
        String searchTerm;

        SimpleProduct product1 = new SimpleProduct("Вишня", 100);

        DiscountedProduct product3 = new DiscountedProduct("Картошка", 60, 15);
        FixPriceProduct product4 = new FixPriceProduct("Молоко");
        DiscountedProduct product5 = new DiscountedProduct("Хлеб \"Бородинский\"", 40, 15);
        SimpleProduct product6 = new SimpleProduct("Сок \"Мультифрукт\"", 240);
        DiscountedProduct product7 = new DiscountedProduct("Масло", 200, 30);
        FixPriceProduct product8 = new FixPriceProduct("Хлеб \"Белый\"");

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);
        basket.addProduct(product7);
        basket.addProduct(product8);

        search.addSearchable(product1);
        search.addSearchable(product3);
        search.addSearchable(product4);
        search.addSearchable(product5);
        search.addSearchable(product6);
        search.addSearchable(product7);
        search.addSearchable(product8);

        try {
            DiscountedProduct Product3 = new DiscountedProduct("Картошка", 120, 115);
            basket.addProduct(Product3);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Продукт не добавлен в корзину\n");
        }
        System.out.println("----\n");

        search.add(new SimpleProduct("Вишня", 100));
        search.add(new SimpleProduct("Черешня", 200));
        search.add(new FixPriceProduct("Кефир"));
        search.add(new FixPriceProduct("Хлеб"));
        search.add(new DiscountedProduct("Картошка", 120, 15));
        search.add(new DiscountedProduct("Яблоки", 110, 15));
        search.add(new DiscountedProduct("Колбаса", 240, 25));

        search.add(new Article("Кефира побольше!", "Кефир " + "Колбаса " + "Кефир " + "Батон " + "Кефир "));
        search.add(new Article("Типичный обед студента.", "Кефир " + "Сайка "));
        search.add(new Article("Рецепт окрошки на кефире.", "Кефир " + "Хлеб " + "Колбаса " + "Яйцо "));

        basket.findExistence("Соль");
        basket.findExistence("Test");

        searchTerm = "Кефир";
        System.out.println(search.searchBestResult(searchTerm));

        basket.deleteItem("хлеб");
        basket.deleteItem("хлеб");

        basket.printBasket();

        System.out.println("----------");

        System.out.println(search.search("Хлеб"));
        System.out.println(search.search("Test"));

        System.out.println("\n***\n");

        System.out.println(search.search("Test"));
        System.out.println(search.search("Хлеб"));
        System.out.println(search.search(null));
    }
}
