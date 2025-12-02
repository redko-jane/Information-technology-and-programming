public class Max {

    static class RowThread extends Thread {
        private int[] row; 
        private int max;
        RowThread(int[] row) { 
            this.row = row; 
        }
        public void run() {
            max = row[0];
            for (int x : row) {
                if (x > max) max = x;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int[][] matrix = {{3,1,4}, {9,2,5}, {7,8,6}};
        
        RowThread[] threads = new RowThread[matrix.length];
        
        for (int i = 0; i < matrix.length; i++) {
            threads[i] = new RowThread(matrix[i]);
            threads[i].start();
        }
        
        for (RowThread t : threads) t.join();
        
        int max = threads[0].max;
        for (RowThread t : threads) if (t.max > max) max = t.max;
        
        System.out.println("Максимум: " + max);
    }
}