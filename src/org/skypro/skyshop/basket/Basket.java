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
        productBasket.computeIfAbsent(product, k -> new ArrayList<>()).add(product);
        System.out.println("Добавлен продукт: " + product.getName());
    }

    // Распечатка содержимого корзины
    public void printBasket() {
        if (!productBasket.isEmpty()) {
            System.out.println("Содержимое корзины:");
        }
        productBasket.values().stream()
                .flatMap(products -> products.stream())
                .forEach(System.out::println);
        if (productBasket.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Итого: " + countTotalPrice());
            System.out.println("Специальных товаров: " + getNumberOfSpecialProducts());
        }
    }

    // Вычисление количества особых продуктов
    private int getNumberOfSpecialProducts() {
        return (int) productBasket.values().stream()
                .flatMap(products -> products.stream())
                .filter(Product::isSpecial)
                .count();
    }

    // Расчет полной стоимости корзины
    public int countTotalPrice() {
        return productBasket.values().stream()
                .flatMap(products -> products.stream())
                .mapToInt(Product::getPrice)
                .sum();
    }

    // Проверка наличия
    public boolean findExistence(String name) {
        return productBasket.values().stream()
                .flatMap(products -> products.stream())
                .anyMatch(product -> product.getName().equals(name));
    }

    // Удаление позиции по получаемому имени продукта
    public List<Product> deleteItem(String searchTerm) {
        List<Product> founded = new LinkedList<>();
        Iterator<Map.Entry<Product, List<Product>>> iterator = productBasket.entrySet().iterator();
        while (iterator.hasNext()) {
            Product search = iterator.next().getKey();
            if (search != null && search.getSearchTerm().equalsIgnoreCase(searchTerm)) {
                founded.add(search);
                iterator.remove();
            }
        }
        return founded;
    }
}
