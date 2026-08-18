public class Solution {
    public int largestInteger(int[] nums, int k) {
        int hash[] = new int[51];
        int max = 0;
        for(int i=0;i<nums.length;i++){
            hash[nums[i]]++;
            max = Math.max(max,nums[i]);
        }
        if(k==nums.length) return max;
        if(k==1){
            for(int i=hash.length-1;i>=0;i--){
                if(hash[i]==1) return i;
            }
            return -1;
        }
        return Math.max(hash[nums[0]]==1?nums[0]:-1,hash[nums[nums.length-1]]==1?nums[nums.length-1]:-1);
    }
}
