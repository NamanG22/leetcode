public class Solution {
    public void rec(int arr[], int s, int dp[]){
        int max = arr[s]-dp[s+1];
        if(s<arr.length-1) max = Math.max(max,arr[s]+arr[s+1]-dp[s+2]);
        if(s<arr.length-2) max = Math.max(max,arr[s]+arr[s+1]+arr[s+2]-dp[s+3]);
        dp[s] = max;
    }
    public String stoneGameIII(int[] stoneValue) {
        int dp[] = new int[stoneValue.length+1];
        for(int i=stoneValue.length-1;i>=0;i--){
            rec(stoneValue, i, dp);
        }
        if(dp[0]>0) return "Alice";
        if(dp[0]==0) return "Tie";
        return "Bob";
    }
}
