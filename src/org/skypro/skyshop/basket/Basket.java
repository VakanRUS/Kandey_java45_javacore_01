package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.tools.Searchable;

import java.util.*;

public class Basket {
    private Map<Product, List<Product>> productBasket;

    public Basket() {
        this.productBasket = new HashMap<>();
    }

    // Добавление товара в корзину
    public void addProduct(Product product) {
        if (product != null) {
            System.out.println("Добавлен продукт: " + product.getName());
        } else {
            System.out.println("Добавлен пустой продукт");
        }
        productBasket.computeIfAbsent(product, k -> new ArrayList<>()).add(product);
    }

    // Распечатка содержимого корзины
    public void printBasket() {
        int numberOfSpecialProducts = 0;
        if (!productBasket.isEmpty()) {
            System.out.println("Содержимое корзины:");
        }
        for (Map.Entry<Product, List<Product>> product : productBasket.entrySet()) {
            Product key = product.getKey();
            if (key != null) {
                System.out.println(key);
            }
            if (key != null && key.isSpecial()) {
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
        for (Map.Entry<Product, List<Product>> entry : productBasket.entrySet()) {
            Product key = entry.getKey();
            if (key != null) {
                int quantity = entry.getValue() == null ? 0 : entry.getValue().size();
                totalPrice += key.getPrice() * quantity;
            }
        }
        return totalPrice;
    }

    // Проверка наличия
    public boolean findExistence(String name) {
        for (Map.Entry<Product, List<Product>> entry : productBasket.entrySet()) {
            Product key = entry.getKey();
            if (key != null && key.getName().toLowerCase().contains(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    // Удаление позиции по получаемому имени продукта
    public List<Searchable> deleteItem(String searchTerm) {
        List<Searchable> founded = new LinkedList<>();
        Iterator<Map.Entry<Product, List<Product>>> iterator = productBasket.entrySet().iterator();
        while (iterator.hasNext()) {
            Product search = iterator.next().getKey();
            if (search != null && search.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                founded.add(search);
                iterator.remove();
            }
        }
        return founded;
    }
}
