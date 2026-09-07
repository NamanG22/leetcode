import java.util.Arrays;

class Solution {
    public int distinctSubseqII(String s) {
        int hash[] = new int[26];
        long dp[] = new long[s.length()+1];
        Arrays.fill(hash,-1);
        dp[s.length()-1]=1;
        hash[s.charAt(s.length()-1)-'a'] = s.length()-1;
        for(int i=s.length()-2;i>=0;i--){
            long res = 0;
            if(hash[s.charAt(i)-'a']==-1){
                res = ((dp[i+1]*2) + 1)%1000000007;
            }
            else{
                res = ((dp[i+1]*2) - dp[hash[s.charAt(i)-'a']+1] + 1000000007)%1000000007;
            }
            hash[s.charAt(i)-'a']=i;
            dp[i] = res;
        }
        return (int)dp[0];
    }
}
