import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BruteForce {
    
    public static List<String> bruteForce(int n, int k) {
        List<String> result = new ArrayList<>();
        if (k < n) {
            return result;
        }
        generateCombinations(n, k, "", result, new boolean[k]);
        return result;
    }
    
    private static void generateCombinations(int n, int k, String current, List<String> result, boolean[] used) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (!used[i]) {
                used[i] = true;
                generateCombinations(n, k, current + i, result, used);
                used[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] parts = input.split(",\\s*");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        scanner.close();
        List<String> result = bruteForce(n, k);
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            System.out.print("\"" + result.get(i) + "\"");
            if (i < result.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}