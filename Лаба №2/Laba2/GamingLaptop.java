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