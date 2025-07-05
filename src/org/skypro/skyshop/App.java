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
    public static void main(String[] args) throws BestResultNotFound {
        Searchable[] found;
        SearchEngine search = new SearchEngine(10);
        String searchTerm;

        Basket basket = new Basket();

        try {
            SimpleProduct Product1 = new SimpleProduct("Вишня", 0);
            basket.addProduct(Product1);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Продукт не добавлен в корзину\n");
        }

        try {
            FixPriceProduct Product2 = new FixPriceProduct("");
            basket.addProduct(Product2);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Продукт не добавлен в корзину\n");
        }

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

        searchTerm = "Кефир";
        found = search.search(searchTerm);
        System.out.println("Поисковый запрос: " + searchTerm);
        for (Searchable founded : found) {
            if (founded != null) {
                System.out.println("ContentType = " + founded.getContentType());
                System.out.println("StringRepresentation = " + founded.getStringRepresentation());
            }
        }

        searchTerm = "Кефир";
        System.out.println(search.searchBestResult(searchTerm));

        System.out.println("----------");

        searchTerm = "Самолёт";
        try {
            System.out.println(search.searchBestResult(searchTerm));
        } catch (BestResultNotFound e) {
            System.out.println(e.toString());
        }

    }
}