import java.util.*;

class Product {
    String name; 
    int weight;
    Product(String name, int weight) { 
        this.name = name; 
        this.weight = weight; 
    }
    public String toString() { 
        return name + "(" + weight + "кг)"; 
    }
}

class Warehouse {
    private List<Product> products = new ArrayList<>();
    private Random random = new Random();
    
    public synchronized Product takeProduct() {
        if (products.isEmpty()) return null;
        return products.remove(0);
    }
    
    public boolean hasProducts() { 
        return !products.isEmpty(); 
    }
    
    public void fillWarehouse() {
        String[] names = {"Телевизор", "Холодильник", "Стиральная машина", "Микроволновка"};
        for (int i = 1; i <= 15; i++) {
            String name = names[random.nextInt(names.length)] + i;
            int weight = random.nextInt(40) + 10;
            products.add(new Product(name, weight));
        }
    }
}

class Loader extends Thread {
    String name; 
    Warehouse warehouse;
    List<Product> cart = new ArrayList<>();
    int total = 0;
    
    Loader(String name, Warehouse warehouse) {
        this.name = name; 
        this.warehouse = warehouse;
    }
    
    public void run() {
        while (warehouse.hasProducts()) {
            Product p = warehouse.takeProduct();
            if (p == null) break;
            
            if (getCartWeight() + p.weight <= 150) {
                cart.add(p);
                System.out.println(name + " взял " + p);
            } else {
                deliver();
                cart.add(p);
            }
            
            try { Thread.sleep(50); } catch (InterruptedException e) {}
        }
        if (!cart.isEmpty()) deliver();
        System.out.println(name + " закончил. Всего: " + total + "кг");
    }
    
    private int getCartWeight() {
        return cart.stream().mapToInt(p -> p.weight).sum();
    }
    
    private void deliver() {
        int weight = getCartWeight();
        total += weight;
        System.out.println("--- " + name + " везет " + weight + "кг: " + cart);
        cart.clear();
        try { Thread.sleep(300); } catch (InterruptedException e) {}
    }
}

public class SimpleWarehouse {
    public static void main(String[] args) throws Exception {
        Warehouse w = new Warehouse();
        w.fillWarehouse();
        
        Loader l1 = new Loader("Грузчик1", w);
        Loader l2 = new Loader("Грузчик2", w);
        Loader l3 = new Loader("Грузчик3", w);
        
        l1.start(); l2.start(); l3.start();
        l1.join(); l2.join(); l3.join();
        
        System.out.println("Работа завершена!");
    }
}