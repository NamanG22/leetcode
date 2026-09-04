class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int min_arr[] = new int[nums.length];
        int res = 101;
        min_arr[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            min_arr[i] = Math.min(min_arr[i+1],nums[i]);
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            if(max-min_arr[i]<=k){
                res = Math.min(i,res);
            }
        }
        return res==101?-1:res;
    }
}
