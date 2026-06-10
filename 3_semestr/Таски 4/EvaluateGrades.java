import java.util.Scanner;
import java.util.LinkedHashMap;

public class EvaluateGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        scanner.close();
        input = input.replace("[", "").replace("]", "");
        String[] gradesStr = input.split(",");
        int[] grades = new int[gradesStr.length];
        for (int i = 0; i < gradesStr.length; i++) {
            grades[i] = Integer.parseInt(gradesStr[i].trim());
        }
        LinkedHashMap<String, Integer> result = evaluateGrades(grades);
        System.out.print("{");
        boolean first = true;
        for (var entry : result.entrySet()) {
            if (entry.getValue() > 0) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(entry.getKey() + ": " + entry.getValue());
                first = false;
            }
        }
        System.out.println("}");
    }
    
    public static LinkedHashMap<String, Integer> evaluateGrades(int[] grades) {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        result.put("A", 0);
        result.put("B", 0);
        result.put("C", 0);
        result.put("D", 0);
        result.put("F", 0);
        for (int grade : grades) {
            if (grade >= 90 && grade <= 100) {
                result.put("A", result.get("A") + 1);
            } else if (grade >= 80 && grade <= 89) {
                result.put("B", result.get("B") + 1);
            } else if (grade >= 70 && grade <= 79) {
                result.put("C", result.get("C") + 1);
            } else if (grade >= 60 && grade <= 69) {
                result.put("D", result.get("D") + 1);
            } else if (grade >= 0 && grade <= 59) {
                result.put("F", result.get("F") + 1);
            }
        }
        return result;
    }
}