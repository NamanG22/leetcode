import java.util.Arrays;

public class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int count = 0;
        int res = 0;
        for(int i=cost.length-1;i>=0;i--){
            if(count==2){
                count = 0;
                continue;
            }
            count++;
            res+=cost[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] cost = {1,2,3,4,5,6};
        System.out.println(solution.minimumCost(cost));
    }
}