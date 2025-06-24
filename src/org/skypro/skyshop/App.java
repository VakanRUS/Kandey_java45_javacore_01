package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.tools.SearchEngine;
import org.skypro.skyshop.tools.Searchable;

public class App {
    public static void main(String[] args) {
        Searchable[] found;
        SearchEngine search = new SearchEngine(10);
        String searchTerm;

        search.add(new SimpleProduct("Вишня", 100));
        search.add(new SimpleProduct("Черешня", 200));
        search.add(new FixPriceProduct("Кефир"));
        search.add(new FixPriceProduct("Хлеб"));
        search.add(new DiscountedProduct("Картошка", 120, 15));
        search.add(new DiscountedProduct("Яблоки", 110, 15));
        search.add(new DiscountedProduct("Колбаса", 240, 25));

        search.add(new Article("Состав салата Оливье.", "Яйца " + "колбаса " + "майонез " + "горошек "));
        search.add(new Article("Типичный обед студента.", "Кефир " + "Сайка "));
        search.add(new Article("Рецепт окрошки на кефире", "Кефир " + "Хлеб " + "Колбаса " + "Яйцо "));

        System.out.println("Поиск существующего товара");
        System.out.println();

        searchTerm = "хлеб";
        found = search.search(searchTerm);
        System.out.println("Поисковый запрос: " + searchTerm);
        for (Searchable founded : found) {
            if (founded != null) {
                System.out.println("ContentType = " + founded.getContentType());
                System.out.println("StringRepresentation = " + founded.getStringRepresentation());
            }
        }

        System.out.println("------------");

        searchTerm = "Кефир";
        found = search.search(searchTerm);
        System.out.println("Поисковый запрос: " + searchTerm);
        for (Searchable founded : found) {
            if (founded != null) {
//                System.out.println("ContentType = " + founded.getContentType());
                System.out.println(founded.getStringRepresentation());
                System.out.println("\n***\n");
            }
        }
    }
}