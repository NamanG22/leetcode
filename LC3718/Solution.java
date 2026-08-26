public class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean hash[] = new boolean[101];
        for(int i:nums){
            hash[i]=true;
        }
        for(int i=1;i*k<=200;i++){
            if(k*i>100 || !hash[k*i]) return k*i;
        }
        return -1;
    }
}
