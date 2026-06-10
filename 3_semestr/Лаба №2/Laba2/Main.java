abstract class Gadgets {
    protected String brand;
    protected String model;
    protected double price;
    private static int gadgetCount = 0;

    public Gadgets() {
        this("Unknown", "Unknown", 0.0);
    }

    public Gadgets(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        if (price > 0) {
            this.price = price;
        }
        gadgetCount++;
    }

    public abstract void info();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public static int getGadgetCount() {
        return gadgetCount;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Демонстрация инкапсуляции");
        Watch watch = new Watch();
        watch.setBrand("Xiaomi");
        watch.setModel("Watch 5");
        watch.setPrice(3499.99);
        watch.setHealthIndicators(true);
        watch.setStepsCounter(1246);
        watch.setBatteryCharge(48);
        
        System.out.println("Бренд: " + watch.getBrand());
        System.out.println("Модель: " + watch.getModel());
        System.out.println("Цена: " + watch.getPrice());
        
        System.out.println("Демонстрация наследования");
        FitnessWatch fitnessWatch = new FitnessWatch("Xiaomi", "Smart Band 10", 5399.99, true, 5483, 72, true, true);
        fitnessWatch.info();
        
        System.out.println("Демонстрация полиморфизма");
        Gadgets[] gadgets = new Gadgets[3];
        gadgets[0] = new Watch("Huawei", "WATCH GT 5 Pro", 19799.99, true, 4237, 18);
        gadgets[1] = new GamingLaptop("ASUS", "TUF Gaming F17", 71999.99, "Intel Core i5", 16, 512, true, 120, "GeForce RTX 3050");
        gadgets[2] = new FitnessWatch("HUAWEI", "Band 10", 2399.99, true, 7823, 63, true, true);
        
        for (Gadgets gadget : gadgets) {
            gadget.info();
            System.out.println(" ");
        }
        
        System.out.println("Демонстрация абстракции");
        Gadgets smartphone = new Smartphone("Samsung", "Galaxy S23", 79999.99,  256, 8, "Type-C");
        smartphone.info();
        
        System.out.println("Демонстрация перегрузки методов");
        GamingLaptop gamingLaptop = new GamingLaptop();
        gamingLaptop.installApp("Angry Birds");
        gamingLaptop.installApp("Genshin Impact", true);
        
        System.out.println("Демонстрация переопределения методов");
        Watch basicWatch = new Watch("Basic", "Watch100", 5000.0, true, 0, 100);
        Watch advancedWatch = new FitnessWatch("Advanced", "FitPro", 15000.0, true, 5000, 80, true, true);

        System.out.println("Базовые часы:");
        basicWatch.measurePulse();

        System.out.println("Фитнес-часы:");
        advancedWatch.measurePulse();
        
        System.out.println("Демонстрация счетчика объектов");
        System.out.println("Всего создано гаджетов: " + Gadgets.getGadgetCount());
    }
}