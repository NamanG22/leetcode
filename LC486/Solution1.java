public class Solution1 {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = nums[i];
        }
        for(int j=1;j<n;j++){
            for(int i=0,k=i+j;k<n;k++,i++){
                dp[i][k] = Math.max(nums[i]-dp[i+1][k],nums[k]-dp[i][k-1]);
            }
        }
        return dp[0][n-1]>=0?true:false;
    }
}
