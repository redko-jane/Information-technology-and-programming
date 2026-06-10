import java.util.Arrays;
import java.util.Scanner;

public class Merge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        System.out.println(Arrays.toString(mergeUniqueSorted(s)).replace(" ", ""));
    }
    public static int[] mergeUniqueSorted(String s) {
        String[] mm = s.split("], \\[");
        String m1 = mm[0].replace("[","").replace("]","").replace(" ", "");
        String m2 = mm[1].replace("[","").replace("]","").replace(" ", "");
        String[] n1 = m1.split(",");
        String[] n2 = m2.split(",");
        int[] all = new int[n1.length + n2.length];
        int index = 0;
        for (String num : n1) {
            if (!num.trim().isEmpty()) {
                all[index++] = Integer.parseInt(num);
            }
        }
        for (String num : n2) {
            if (!num.trim().isEmpty()) {
                all[index++] = Integer.parseInt(num);
            }
        }
        all = Arrays.copyOf(all, index);
        int[] u = new int[0];
        for (int i = 0; i < all.length; i++) {
            boolean x = true;
            for (int j = i+1; j < all.length; j++) {
                if (all[i] == all[j]) {
                    x = false;
                }
            }
            if (x) {
                int[] newU = Arrays.copyOf(u, u.length + 1);
                newU[u.length] = all[i];
                u = newU;
            }
        }
        Arrays.sort(u);
        return u;
    }
}