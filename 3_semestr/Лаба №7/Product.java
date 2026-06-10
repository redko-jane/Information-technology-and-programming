import java.util.*;

public class Product {
    String name; 
    int weight;
    Product(String name, int weight) { 
        this.name = name; 
        this.weight = weight; 
    }
    public String toString() { 
        return name + "(" + weight + "кг)"; 
    }
}