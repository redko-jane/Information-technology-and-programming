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