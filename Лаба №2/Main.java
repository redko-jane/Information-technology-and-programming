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

class Watch extends Gadgets {
    private boolean healthIndicators;
    private int stepsCounter;
    private int batteryCharge;

    public Watch() {
        super();
    }

    public Watch(String brand, String model, double price, boolean healthIndicators, int stepsCounter, int batteryCharge) {
        super(brand, model, price);
        this.healthIndicators = healthIndicators;
        this.stepsCounter = stepsCounter;
        this.batteryCharge = batteryCharge;
    }

    @Override
    public void info() {
        System.out.println("Умные часы: " +  brand + " " + model);
        System.out.println("Цена: " + price + " руб.");
        System.out.print("Показатели здоровья: ");
        if (healthIndicators) {
            System.out.println("есть");
        }
        else {
            System.out.println("нет");
        }
        System.out.println("Количество шагов за сегодняшний день: " + stepsCounter);
        System.out.println("Заряд батареи: " + batteryCharge);
    }

    public void measurePulse() {
        if (healthIndicators) {
            System.out.println("Измерение пульса...");
        }
        else {
            System.out.println("Функция недоступна");
        }
    }

    public void measurePressure() {
        if (healthIndicators) {
            System.out.println("Измерение артериального давления...");
        }
        else {
            System.out.println("Функция недоступна");
        }
    }

    public boolean getHealthIndicators() {
        return healthIndicators;
    }

    public void setHealthIndicators(boolean healthIndicators) {
        this.healthIndicators = healthIndicators;
    }

    public int getStepsCounter() {
        return stepsCounter;
    }

    public void setStepsCounter(int stepsCounter) {
        if (stepsCounter > -1) {
            this.stepsCounter = stepsCounter;
        }
    }

    public int getBatteryCharge() {
        return batteryCharge;
    }

    public void setBatteryCharge(int batteryCharge) {
        if (batteryCharge > -1 && batteryCharge <= 100) {
            this.batteryCharge = batteryCharge;
        }
    }
}


class Smartphone extends Gadgets {
    private int camera;
    private int RAM;
    private String chargingInterface;

    public Smartphone() {
        super();
    }

    public Smartphone(String brand, String model, double price, int camera, int RAM, String chargingInterface) {
        super(brand, model, price);
        this.camera = camera;
        this.RAM = RAM;
        this.chargingInterface = chargingInterface;
    }

    @Override
    public void info() {
        System.out.println("Смартфон: " + brand + " " + model);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Разрешение камеры: " + camera + " Мп");
        System.out.println("Объём оперативной памяти: " + RAM + " ГБ");
        System.out.println("Интерфейс для зарядки: " + chargingInterface);
    }

    public void call(String number) {
        if ((number.length() == 11 && number.charAt(0) == '8') || (number.length() == 12 && number.charAt(0) == '+' && number.charAt(0) == '7')) {
            System.out.println("Устанавливается соединение с абонентом " + number);
        }
        else {
            System.out.println("Введен некорректный номер");
        }
    }

    public void photo() {
        System.out.println("Сделано новое фото");
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        if (camera > 0) {
            this.camera = camera;
        }
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        if (RAM > 0) {
            this.RAM = RAM;
        }
    }

    public String getChargingInterface() {
        return chargingInterface;
    }

    public void setChargingInterface(String chargingInterface) {
        this.chargingInterface = chargingInterface;
    }
}

class Laptop extends Gadgets {
    private String processor;
    private int RAM;
    private int SSD;

    public Laptop() {
        super();
    }

    public Laptop(String brand, String model, double price, String processor, int RAM, int SSD) {
        super(brand, model, price);
        this.processor = processor;
        this.RAM = RAM;
        this.SSD = SSD;
    }

    @Override
    public void info() {
        System.out.println("Ноутбук: " + brand + " " + model);
        System.out.println("Цена: " + price);
        System.out.println("Процессор: " + processor);
        System.out.println("Объём оперативной памяти: " + RAM);
        System.out.println("Объём встроенной памяти: " + SSD);
    }

    public void installApp(String app) {
        System.out.println("Установка приложения " + app);
    }

    public void playbackVideo() {
        System.out.println("Вопроизводится видео...");
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }
    
    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        if (RAM > 0) {
            this.RAM = RAM;
        }
    }

    public int getSSD() {
        return SSD;
    }

    public void setSSD(int SSD) {
        if (SSD > 0) {
            this.SSD = SSD;
        }
    }
}

class FitnessWatch extends Watch {
    private boolean sleepTracking;
    private boolean alarm;

    public FitnessWatch() {
        super();
    }

    public FitnessWatch(String brand, String model, double price, boolean healthIndicators, int stepsCounter, int batteryCharge, boolean sleepTracking, boolean alarm) {
        super(brand, model, price, healthIndicators, stepsCounter, batteryCharge);
        this.sleepTracking = sleepTracking;
        this.alarm = alarm;
    }

    @Override
    public void info() {
        super.info();
        System.out.print("Анализ сна: ");
        if (sleepTracking) {
            System.out.println("есть");
        }
        else {
            System.out.println("нет");
        }
        System.out.print("Умный будильник: ");
        if (alarm) {
            System.out.println("есть");
        }
        else {
            System.out.println("нет");
        }
    }

    @Override
    public void measurePulse() {
        if (getHealthIndicators()) {
            System.out.println("Измерение пульса с повышенной точностью...");
            System.out.println("Анализ вариабельности сердечного ритма...");
        } else {
            System.out.println(brand + " " + model + ": Функция измерения пульса недоступна");
        }
    }

    public void sleepTrack() {
        if (sleepTracking) {
            System.out.println("Анализ качества сна...");
        }
        else {
            System.out.println("Функция недоступна");
        }
    }

    public void onAlarm(String time) {
        if (alarm) {
            System.out.println("Установлен будильник на " + time);
        }
        else {
            System.out.println("Функция недоступна");
        }
    }

    public boolean getSleepTracking() {
        return sleepTracking;
    }

    public void setSleepTracking(boolean sleepTracking) {
        this.sleepTracking = sleepTracking;
    }

    public boolean getAlarm() {
        return alarm;
    }

    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }
}

class GamingLaptop extends Laptop {
    private boolean coolingSystem;
    private int refreshRate;
    private String graphicsCard;

    public GamingLaptop() {
        super();
    }

    public GamingLaptop(String brand, String model, double price, String processor, int RAM, int SSD, boolean coolingSystem, int refreshRate, String graphicsCard) {
        super(brand, model, price, processor, RAM, SSD);
        this.coolingSystem = coolingSystem;
        this.refreshRate = refreshRate;
        this.graphicsCard = graphicsCard;
    }

    @Override
    public void info() {
        super.info();
        System.out.print("Система охлаждения: ");
        if (coolingSystem) {
            System.out.println("есть");
        }
        else {
            System.out.println("нет");
        }
    }

    public void onGamingMode() {
        System.out.println("Игровой режим активирован");
    }

    public void launchGame(String game) {
        System.out.println("Запуск игры " + game + " на видеокарте " + graphicsCard);
    }

    public void installApp(String app, boolean gamingOptimized) {
        if (gamingOptimized) {
            System.out.println("Установка оптимизированной для игр версии: " + app);
        } 
        else {
            installApp(app);
        }
    }

    public boolean getCoolingSystem() {
        return coolingSystem;
    }
    public void setCoolingSystem(boolean coolingSystem) {
        this.coolingSystem = coolingSystem;
    }

    public int getRefreshRate() {
        return refreshRate;
    }
    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }
    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
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
                
        System.out.println("Информация о всех созданных объектах ");
        Gadgets[] allGadgets = {watch, fitnessWatch, smartphone, gamingLaptop};
        for (int i = 0; i < allGadgets.length; i++) {
            System.out.println("Гаджет #" + (i + 1) + ":");
            allGadgets[i].info();
            System.out.println();
        }
    }
}
