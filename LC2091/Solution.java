class Solution {
    public int minimumDeletions(int[] nums) {
        int min = 0;
        int max = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[max]) max = i;
            else if(nums[i]<nums[min]) min = i;
        }
        int a = Math.max(min+1,max+1);
        int b = min+1+nums.length-max;
        int c = nums.length-min+max+1;
        int d = Math.max(nums.length-min,nums.length-max);
        return Math.min(Math.min(a,b),Math.min(c,d));
    }
}
