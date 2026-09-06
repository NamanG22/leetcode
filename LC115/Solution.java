class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()+1][t.length()+1];
        for(int i=0;i<dp.length;i++){
            dp[i][t.length()]=1;
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j=t.length()-1;j>=0;j--){
                int res = 0;
                res+=dp[i+1][j];
                if(s.charAt(i)==t.charAt(j)){
                    res+=dp[i+1][j+1];
                }
                dp[i][j]=res;
            }
        }
        return dp[0][0];
    }
}
