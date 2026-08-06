public class Solution {
    public int smallestNumber(int n, int t) {
        int res = n;
        int product = 1;
        while(true){
            int hundredsPlace = res/100;
            int tensPlace = (res%100)/10;
            int onesPlace = res%10;
            if(hundredsPlace==0){
                if(tensPlace==0) product*=onesPlace;
                else product*=(onesPlace*tensPlace);
            }
            else product*=(onesPlace*tensPlace*hundredsPlace);
            if(product%t==0) break;
            product=1;
            res++;
        }
        return res;
    }
}
