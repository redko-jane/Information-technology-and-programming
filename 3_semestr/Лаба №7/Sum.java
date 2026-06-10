public class Sum {

    static class SumThread extends Thread {
        private int[] array;
        private int start, end;
        public long result;
        
        public SumThread(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        
        public void run() {
            result = 0;
            for (int i = start; i < end; i++) {
                result += array[i];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        SumThread t1 = new SumThread(numbers, 0, numbers.length/2);
        SumThread t2 = new SumThread(numbers, numbers.length/2, numbers.length);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long total = t1.result + t2.result;
        System.out.println("Сумма: " + total);
    }
}