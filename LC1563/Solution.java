public class Solution {
    public int rec(int prefixSum[], int s, int e, int dp[][]){
        if(s>=e) return 0;
        if(dp[s][e]!=-1) return dp[s][e];
        int max = 0;
        for(int i=s;i<=e;i++){
            int left = prefixSum[i+1]-prefixSum[s];
            int right = prefixSum[e+1]-prefixSum[i+1];
            
            if(left>right) max = Math.max(max,right+rec(prefixSum,i+1,e,dp));
            else if(left<right) max = Math.max(max,left+rec(prefixSum,s,i,dp));
            else{   
                max = Math.max(max,left+rec(prefixSum,s,i,dp));
                max = Math.max(max,right+rec(prefixSum,i+1,e,dp));
            }
        }
        dp[s][e] = max;
        return max;
    }
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int prefixSum[] = new int[n+1];
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        for(int i=1;i<=n;i++){
            prefixSum[i] = prefixSum[i-1]+stoneValue[i-1];
        }
        return rec(prefixSum,0,n-1,dp);
    }
}
