import java.util.*;

public class SalesManager {
    private HashMap<String, Integer> sales;
    private double totalRevenue;
    
    public SalesManager() {
        sales = new HashMap<>();
        totalRevenue = 0.0;
    }
    
    public void addSale(String product, double price) {
        sales.put(product, sales.getOrDefault(product, 0) + 1);
        totalRevenue += price;
    }
    
    public void printSales() {
        System.out.println("Список проданных товаров:");
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " шт.");
        }
    }
    
    public double getTotalRevenue() {
        return totalRevenue;
    }
    
    public String getMostPopularProduct() {
        if (sales.isEmpty()) {
            return "Нет продаж";
        }
        
        String mostPopular = "";
        int maxSales = 0;
        
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        
        return mostPopular + " (продано: " + maxSales + " шт.)";
    }
    
    public int getTotalItemsSold() {
        int total = 0;
        for (int quantity : sales.values()) {
            total += quantity;
        }
        return total;
    }

    public static void main(String[] args) {
        SalesManager manager = new SalesManager();
        manager.addSale("Яблоки", 50.0);
        manager.addSale("Бананы", 30.0);
        manager.addSale("Яблоки", 50.0);
        manager.addSale("Хлеб", 25.0);
        manager.addSale("Бананы", 30.0);
        manager.addSale("Бананы", 30.0);
        manager.addSale("Молоко", 40.0);
        manager.printSales();
        System.out.println("\nОбщая статистика:");
        System.out.println("Всего продано товаров: " + manager.getTotalItemsSold() + " шт.");
        System.out.println("Общая сумма продаж: " + manager.getTotalRevenue() + " руб.");
        System.out.println("Самый популярный товар: " + manager.getMostPopularProduct());
    }
}