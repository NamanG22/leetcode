public class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long xx = 0;
        int sum = 0;
        while(n>0){
            if(n%10>0){
                x*=10;
                x+=(n%10);
                sum+=(n%10);
            }
            n/=10;
        }
        while(x>0){
            xx*=10;
            xx+=(x%10);
            x/=10;
        }
        return xx*sum;
    }
}
