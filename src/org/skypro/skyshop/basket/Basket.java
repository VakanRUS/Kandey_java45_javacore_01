package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class Basket {
    private Product[] productBasket = new Product[5];

    // Добавление товара в корзину
    public void addProduct(Product product) {
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = product;
                System.out.println("Добавлен продукт: " + product.getName());
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    // Распечатка содержимого корзины
    public void printBasket() {
        int numberOfSpecialProducts = 0;
        if (checkIsBasketEmpty() == false) {
            System.out.println("Содержимое корзины:");
        }
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null) {
                System.out.println(productBasket[i].toString());
            }
            if (productBasket[i] != null && productBasket[i].isSpecial()) {
                numberOfSpecialProducts++;
            }
        }
        if (checkIsBasketEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Итого: " + countTotalPrice());
            System.out.println("Специальных товаров: " + numberOfSpecialProducts);
        }
    }

    // Расчет полной стоимости корзины
    public int countTotalPrice() {
        int totalPrice = 0;
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null) {
                totalPrice += productBasket[i].getPrice();
            }
        }
        return totalPrice;
    }

    // Проверка наличия
    public boolean findExistence(String name) {
        boolean check = false;
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null && productBasket[i].getName().equals(name)) {
                check = true;
                System.out.println("Поиск: " + name + " - товар уже добавлен в корзину");
                return check;
            }
        }
        System.out.println("Поиск: " + name + " - товар в корзине не найден");
        return check;
    }

    // проверка заполненности корзины
    public boolean checkIsBasketEmpty() {
        boolean check = true;
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null) {
                check = false;
                break;
            }
        }
        return check;
    }

        // Очистка корзины
    public void cleanBasket() {
        for (byte i = 0; i < productBasket.length; i++) {
            productBasket[i] = null;
        }
        System.out.println("Корзина очищена");
    }
}