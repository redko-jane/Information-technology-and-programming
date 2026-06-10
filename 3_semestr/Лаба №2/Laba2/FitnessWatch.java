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