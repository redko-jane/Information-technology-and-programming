import java.util.Scanner;

public class CountIslands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        scanner.close();
        int[][] grid = parseGrid(input);
        int result = countIslands(grid);
        System.out.println(result);
    }
    
    private static int[][] parseGrid(String input) {
        input = input.substring(2, input.length() - 2);
        String[] rows = input.split("\\],\\[");
        int numRows = rows.length;
        int numCols = rows[0].split(",").length;
        int[][] grid = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            String[] values = rows[i].split(",");
            for (int j = 0; j < numCols; j++) {
                grid[i][j] = Integer.parseInt(values[j].trim());
            }
        }
        return grid;
    }
    
    public static int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(grid, visited, i, j, rows, cols);
                }
            }
        }
        return count;
    }
    
    private static void dfs(int[][] grid, boolean[][] visited, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || 
            grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(grid, visited, i - 1, j, rows, cols);
        dfs(grid, visited, i + 1, j, rows, cols);
        dfs(grid, visited, i, j - 1, rows, cols);
        dfs(grid, visited, i, j + 1, rows, cols);
    }
}