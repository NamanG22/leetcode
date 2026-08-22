public class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int nn = n;
        while(n>0){
            sum+=n%10;
            product*=n%10;
            n/=10;
        }
        return nn%(sum+product)==0;
    }
}
