class Solution {
    public long countCommas(long n) {
        long res = 0;
        if(n<=999) return res;
        if(n<=999999) return n-999;
        res+=999999-999;
        if(n<=999999999) return res + 2*(n-999999);
        res+=2*(999999999-999999);
        if(n<=999999999999L) return res + 3*(n-999999999);
        res+=3*(999999999999L-999999999L);
        if(n<=999999999999999L) return res + 4*(n-999999999999L);
        res+=4*(999999999999999L-999999999999L);
        if(n==1000000000000000L) return res + 5;
        return res;
    }
}
