import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int arr[][] = new int[m][n];
        List<List<Integer>> ll = new ArrayList<>();
        for(int i=0;i<m;i++){
            int mod = k%n;
            for(int j=0;j<n;j++){
                arr[(i+((k+j)/n))%m][(j+mod)%n] = grid[i][j];
            }
        }
        for(int i=0;i<m;i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<n;j++){
                l.add(arr[i][j]);
            }
            ll.add(l);
        }
        return ll;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution.shiftGrid(grid, 1));
        System.out.println(solution.shiftGrid(grid, 9));
    }
}
