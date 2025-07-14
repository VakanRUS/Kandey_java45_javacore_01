package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.tools.Searchable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Basket {
    private List<Product> productBasket = new ArrayList<>();

    // Добавление товара в корзину
    public void addProduct(Product product) {
        productBasket.add(product);
        System.out.println("Добавлен продукт: " + product.getName());

    }

    // Распечатка содержимого корзины
    public void printBasket() {
        int numberOfSpecialProducts = 0;
        if (!checkIsBasketEmpty()) {
            System.out.println("Содержимое корзины:");
        }
        for (Product products : productBasket) {
            if (products != null) {
                System.out.println(products);
            }
            if (products != null && products.isSpecial()) {
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
        for (Product products : productBasket) {
            totalPrice += products.getPrice();

        }
        return totalPrice;
    }

    // Проверка наличия
    public boolean findExistence(String name) {
        boolean check = false;
        for (Product products : productBasket) {
            if (products.getName().equals(name)) {
                check = true;
                System.out.println("Поиск: " + name + " - товар уже добавлен в корзину");
                return check;
            }
        }
        System.out.println("Поиск: " + name + " - товар в корзине не найден");
        return check;
    }

    // Очистка корзины
    public void cleanBasket() {
        productBasket.removeAll(productBasket);
        System.out.println("Корзина очищена");
    }

    // Удаление позиции по получаемому имени продукта
    public void deleteItem(String searchTerm) {
        System.out.println("Поиск и удаление из корзины продукта \"" + searchTerm + "\"");
        List<Searchable> founded = new LinkedList<>();
        Iterator<Product> iterator = productBasket.iterator();
        Searchable search;
        while (iterator.hasNext()) {
            search = iterator.next();
            if (search.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                founded.add(search);
                iterator.remove();
            }
        }
        if (founded.isEmpty()) {
            System.out.println("Продукт не найден\n" + founded + "\n");
        } else {
            System.out.println("Продукт найден и удалён. Список удалённых продуктов:\n" + founded + "\n");
        }
    }
}