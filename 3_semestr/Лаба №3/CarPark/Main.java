public class Main {
    public static void main(String[] args) {
        CarPark park = new CarPark();
            
        park.addCar("А123ВС77", "Toyota", "Camry", 2020);
        park.addCar("В456ОР77", "BMW", "X5", 2021);
        park.addCar("С789ТУ77", "Mercedes", "E-Class", 2019);
            
        System.out.println("Все автомобили (" + park.getCount() + "):");
        park.displayAll();
            
        System.out.println("\nПоиск А123ВС77:");
        Car car = park.findCar("А123ВС77");
        if (car != null) {
            System.out.println("Найден: " + car);
        }
        else {
            System.out.println("Не найден");
        }
            
        System.out.println("\nУдаляем В456ОР77:");
        park.removeCar("В456ОР77");
        System.out.println("Теперь автомобилей: " + park.getCount());
    }
}