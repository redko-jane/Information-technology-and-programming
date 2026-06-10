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