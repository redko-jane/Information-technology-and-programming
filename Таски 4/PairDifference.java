import java.util.*;

public class PairDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        String[] parts = input.split("], ");
        String arrayStr = parts[0].replace("[", "");
        int k = Integer.parseInt(parts[1]);
        
        String[] numStrs = arrayStr.split(",");
        int[] nums = new int[numStrs.length];
        for (int i = 0; i < numStrs.length; i++) {
            nums[i] = Integer.parseInt(numStrs[i].trim());
        }
        System.out.println(pairDifference(nums, k));
    }

    public static int pairDifference(int[] n, int k) {
        int count = 0;
        for (int i = 0; i < n.length-1; i++) {
            for (int j = i+1; j < n.length; j++) {
                if (Math.abs(n[i]-n[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }
}