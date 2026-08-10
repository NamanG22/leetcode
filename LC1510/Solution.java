public class Solution {
    public boolean winnerSquareGame(int n) {
        boolean dp[] = new boolean[n+1];
        dp[1] = true;
        dp[0] = false;
        q:for(int i=2;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                if(!dp[i-(j*j)]){
                    dp[i] = true;
                    continue q;
                }
            }
            dp[i] = false;
        }
        return dp[n];
    }
}
