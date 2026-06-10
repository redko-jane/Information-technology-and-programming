import java.util.*;

public class CarPark {
    private Map<String, Car> cars = new HashMap<>();

    public void addCar(String plate, String brand, String model, int year) {
        cars.put(plate, new Car(plate, brand, model, year));
    }

    public Car findCar(String plate) {
        return cars.get(plate);
    }

    public void removeCar(String plate) {
        cars.remove(plate);
    }

    public void displayAll() {
        Car[] carArray = cars.values().toArray(new Car[0]);
        for (int i=0; i<carArray.length; i++) {
            System.out.println(carArray[i]);
        }
    }

    public int getCount() {
        return cars.size();
    }
}