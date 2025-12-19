import java.util.*;

public class WordHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        
        String[] words = sc.nextLine().toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        
        System.out.print("{");
        int i = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (i++ > 0) System.out.print(", ");
            System.out.print(e.getKey() + ": " + e.getValue());
        }
        System.out.print("}");
    }
}
