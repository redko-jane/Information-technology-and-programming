import java.util.Scanner;

public class Sequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        s = s.replace("[","").replace("]","").replace(" ","").replace(",","");
        System.out.println(maxConsecutiveOnes(s));
    }

    public static int maxConsecutiveOnes(String s) {
        int m = 0;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                k++;
            }
            else {
                if (k > m) {
                    m = k;
                }
                k = 0;
            }
        }
        if (k > m) {
            m = k;
        }
        return m;
    }
}