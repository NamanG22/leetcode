public class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=stones[i];
        }
        int max = sum;
        int prev = 0;
        for(int i=n-2;i>=0;i--){
            int curr = Math.max(sum-prev,max);
            if(max<curr) max = curr;
            prev = curr;
            sum-=stones[i+1];
        }
        return prev;
    }
}
