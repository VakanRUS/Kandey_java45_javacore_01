package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

public class Basket {
    static Product[] productBasket = new Product[5];
    static int totalPrice = 0;

    // Добавление простого товара в корзину
    public static void addSimpleProduct(String name, int price) {
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = new SimpleProduct(name, price);
                System.out.println("Продукт добавлен в корзину: " + name + ": " + price);
                Product.setCheckIsBasketFull(i + 1);
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    // Добавление товара со скидкой в корзину
    public static void addDiscountProduct(String name, int price) {
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = new DiscountedProduct(name, price);
                System.out.println("Продукт добавлен в корзину: " + name + ": " + price);
                Product.setCheckIsBasketFull(i + 1);
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    // Добавление Простого товара в корзину
    public static void addFixPricedProduct(String name) {
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = new FixPriceProduct(name, FixPriceProduct.getPrice);
                System.out.println("Продукт добавлен в корзину: " + name + ": " + productBasket[i].getPrice());
                Product.setCheckIsBasketFull(i + 1);
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    // Распечатка содержимого корзины
    public static void printBasket() {
        int numberOfSpecialProducts = 0;
        if (Product.getCheckIsBasketFull() != 0) {
            System.out.println("Содержимое корзины:");
        }
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null) {
                System.out.println(productBasket[i].toString());
            }
            if (productBasket[i] != null && productBasket[i].isSpecial()){
                numberOfSpecialProducts++;
            }
        }
        if (Product.getCheckIsBasketFull() == 0) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Итого: " + Basket.countTotalPrice());
            System.out.println("Специальных товаров: " + numberOfSpecialProducts);
        }
    }

    // Расчет полной стоимости корзины
    public static int countTotalPrice() {
        totalPrice = 0;
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null) {
                totalPrice += productBasket[i].getPrice();
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