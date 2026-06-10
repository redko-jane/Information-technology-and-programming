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