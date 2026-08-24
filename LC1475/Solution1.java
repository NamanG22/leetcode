public class Solution1 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int nextLowerElement[] = new int[n];
        for(int i=n-2;i>=0;i--){
            int next = i+1;
            while(true){
                if(prices[next]<=prices[i]){
                    nextLowerElement[i] = next;
                    break;
                }
                if(nextLowerElement[next]==0){
                    nextLowerElement[i]=0;
                    break;
                }
                next = nextLowerElement[next];
            }
        }
        for(int i=0;i<n;i++){
            if(nextLowerElement[i]!=0) prices[i]-=prices[nextLowerElement[i]];
        }
        return prices;
    }
}
