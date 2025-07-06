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
        if (product != null) {
            productBasket.add(product);
            System.out.println("Добавлен продукт: " + product.getName());
        } else {
            productBasket.add(product);
            System.out.println("Добавлен пустой продукт");
//            System.out.println("Нельзя добавить пустой продукт");
        }
    }

    // Распечатка содержимого корзины
    public void printBasket() {
        int numberOfSpecialProducts = 0;
        if (!productBasket.isEmpty()) {
            System.out.println("Содержимое корзины:");
        }
        for (Product product : productBasket) {
            if (product != null) {
                System.out.println(product);
            }
            if (product != null && product.isSpecial()) {
                numberOfSpecialProducts++;
            }
        }
        if (productBasket.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Итого: " + countTotalPrice());
            System.out.println("Специальных товаров: " + numberOfSpecialProducts);
        }
    }

    // Расчет полной стоимости корзины
    public int countTotalPrice() {
        int totalPrice = 0;
        for (Product product : productBasket) {
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    // Проверка наличия
    public boolean findExistence(String name) {
        boolean check = false;
        for (Product product : productBasket) {
            if (product != null && product.getName().equals(name)) {
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
    public List<Searchable> deleteItem(String searchTerm) {
        List<Searchable> founded = new LinkedList<>();
        Iterator<Product> iterator = productBasket.iterator();
        Searchable search;
        while (iterator.hasNext()) {
            search = iterator.next();
            if (search != null && search.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                founded.add(search);
                iterator.remove();
            }
        }
        return founded;
    }
}