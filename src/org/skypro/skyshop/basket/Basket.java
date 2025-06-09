package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class Basket {
    static Product[] productBasket = new Product[5];
    static int totalPrice = 0;

    // Добавление товара в корзину
    public static void addToBasket(String name, int price) {
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = new Product(name, price);
                System.out.println("Продукт добавлен в корзину: " + name + ": " + price);
                Product.setCheckIsBasketFull(i + 1);
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }


    // Распечатка содержимого корзины
    public static void printBasket() {
        if (Product.getCheckIsBasketFull() != 0) {
            System.out.println("Содержимое корзины:");
        }
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null) {
                System.out.println(productBasket[i].getProductName() + ": " + productBasket[i].getProductPrice());
            }
        }
        if (Product.getCheckIsBasketFull() == 0) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Итого: " + Basket.countTotalPrice());
        }
    }

    // Расчет полной стоимости корзины
    public static int countTotalPrice() {
        totalPrice = 0;
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null) {
                totalPrice += productBasket[i].getProductPrice();
            }
        }
        return totalPrice;
    }

    // Проверка наличия
    public static boolean checkExistence(String name) {
        boolean check = false;
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null && productBasket[i].getProductName().equals(name)) {
                check = true;
                System.out.println("Поиск: " + name + " - товар уже добавлен в корзину");
                return check;
            }
        }
        System.out.println("Поиск: " + name + " - товар в корзине не найден");
        return check;
    }

    // Очистка корзины
    public static void CleanBasket() {
        for (byte i = 0; i < productBasket.length; i++) {
            productBasket[i] = null;
            totalPrice = 0;
        }
        Product.setCheckIsBasketFull(0);
        System.out.println("Корзина очищена");
    }
}