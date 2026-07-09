import java.util.Arrays;

public class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int counter = 0;
        int hash[] = new int[n];
        boolean res[] = new boolean[queries.length];
        for(int i=1;i<n;i++){
            if(Math.abs(nums[i-1]-nums[i])>maxDiff) counter++;
            hash[i] = counter;
        }
        for(int i=0;i<queries.length;i++){
            if(hash[queries[i][0]]==hash[queries[i][1]]) res[i] = true;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.pathExistenceQueries(
                2, new int[]{1, 3}, 1, new int[][]{{0, 0}, {0, 1}})));
        System.out.println(Arrays.toString(solution.pathExistenceQueries(
                4, new int[]{2, 5, 6, 8}, 2, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}})));
    }
}
