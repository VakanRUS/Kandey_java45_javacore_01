package org.skypro.skyshop;

import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Basket basket = new Basket();

        SimpleProduct product1 = new SimpleProduct("Вишня", 100);
        FixPriceProduct product2 = new FixPriceProduct("Яблоки");
        DiscountedProduct product3 = new DiscountedProduct("Картошка", 60, 15);
        FixPriceProduct product4 = new FixPriceProduct("Молоко");
        DiscountedProduct product5 = new DiscountedProduct("Хлеб", 40, 15);
        FixPriceProduct productTest = new FixPriceProduct("Test");

        System.out.println("1. Добавление продукта в корзину.");
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        System.out.println();

        System.out.println("2. Добавление продукта в заполненную корзину, в которой нет свободного места.");
        basket.addProduct(productTest);
        System.out.println();

        System.out.println("3. Печать содержимого корзины с несколькими товарами.");
        basket.printBasket();
        System.out.println();

        System.out.println("4. Получение стоимости корзины с несколькими товарами.");
        System.out.println("Итого: " + basket.countTotalPrice());
        System.out.println();

        System.out.println("5. Поиск товара, который есть в корзине.");
        basket.findExistence("Хлеб");
        System.out.println();

        System.out.println("6. Поиск товара, которого нет в корзине.");
        basket.findExistence("Test");
        System.out.println();

        System.out.println("7. Очистка корзины.");
        basket.cleanBasket();
        System.out.println();

        System.out.println("8. Печать содержимого пустой корзины.");
        basket.printBasket();
        System.out.println();

        System.out.println("9. Получение стоимости пустой корзины.");
        System.out.println("Итого: " + basket.countTotalPrice());
        System.out.println();

        System.out.println("10. Поиск товара по имени в пустой корзине.");
        basket.findExistence("Хлеб");
        System.out.println();
    }
}