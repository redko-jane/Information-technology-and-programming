public class Car {
    private String licensePlate;
    private String brand;
    private String model;
    private int year;

    public Car(String licensePlate, String brand, String model, int year) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return brand + " " + model + " (" + year + ") " + "[" + licensePlate + "]";
    }
}
