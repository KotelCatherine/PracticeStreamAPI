package ru.top.academy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * - Найдите общее количество проданных единиц всех продуктов.
 * - Найдите общую сумму продаж (сумма quantity * unitPrice для всех транзакций).
 * - Найдите продукт с наибольшим количеством продаж.
 * - Найдите продукт с наименьшей суммой продаж.
 */

public class StreamApp {
    static List<Transaction> transactions = Arrays.asList(
            new Transaction("Tomato", 2, 5.00),
            new Transaction("Orange", 15, 15.00),
            new Transaction("Carrot", 3, 2.00));

    public StreamApp() {
        System.out.println("Общее количество проданных единиц всех продуктов + [" + totalQuantityMethod() + "]");
        System.out.println("Общая сумма продаж [" + totalSumMethod() + "]");
        System.out.println("Продукт с наибольшим количеством продаж:\n" + maxQuantityMethod());
        System.out.println("Продукт с наименьшей суммой продаж:\n" + minSumMethod());
    }

    private static Transaction minSumMethod() {
        return transactions.stream()
                .min(Comparator.comparingDouble(Transaction::getUnitPrice))
                .orElse(null);
    }

    private static Transaction maxQuantityMethod() {
        return transactions.stream()
                .max(Comparator.comparingInt(Transaction::getQuantity))
                .orElse(null);
    }

    private static double totalSumMethod() {
        return transactions.stream()
                .mapToDouble(a -> a.getQuantity() * a.getUnitPrice())
                .sum();
    }

    private static int totalQuantityMethod() {
        List<Integer> listQuantityProducts = createListQuantityProducts();
        return listQuantityProducts.stream()
                .reduce(0, Integer::sum);
    }

    private static List<Integer> createListQuantityProducts() {
        return transactions.stream()
                .map(Transaction::getQuantity)
                .toList();
    }
}
