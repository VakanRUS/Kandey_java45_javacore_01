package org.skypro.skyshop;

import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        System.out.println("1. Добавление продукта в корзину.");
        Basket.addToBasket("Яблоки", 50);
        Basket.addToBasket("Вишня", 100);
        Basket.addToBasket("Картошка", 60);
        Basket.addToBasket("Кефир", 90);
        Basket.addToBasket("Хлеб", 40);
        System.out.println();

        System.out.println("2. Добавление продукта в заполненную корзину, в которой нет свободного места.");
        Basket.addToBasket("Тест", 1000);
        System.out.println();

        System.out.println("3. Печать содержимого корзины с несколькими товарами.");
        Basket.printBasket();
        System.out.println();

        System.out.println("4. Получение стоимости корзины с несколькими товарами.");
        System.out.println("Итого: " + Basket.countTotalPrice());
        System.out.println();

        System.out.println("5. Поиск товара, который есть в корзине.");
        Basket.checkExistence("Хлеб");
        System.out.println();

        System.out.println("6. Поиск товара, которого нет в корзине.");
        Basket.checkExistence("Test");
        System.out.println();

        System.out.println("7. Очистка корзины.");
        Basket.CleanBasket();
        System.out.println();

        System.out.println("8. Печать содержимого пустой корзины.");
        Basket.printBasket();
        System.out.println();

        System.out.println("9. Получение стоимости пустой корзины.");
        System.out.println("Итого: " + Basket.countTotalPrice());
        System.out.println();

        System.out.println("10. Поиск товара по имени в пустой корзине.");
        Basket.checkExistence("Хлеб");
        System.out.println();
    }
}