public class Solution {
    public int missingInteger(int[] nums) {
        boolean hash[] = new boolean[2501];
        for(int i=0;i<nums.length;i++){
            hash[nums[i]]=true;
        }
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                sum += nums[i];
            }
            else{
                while(true){
                    if(hash[sum]) sum++;
                    else return sum;
                }
            }
        }
        while(true){
            if(hash[sum]) sum++;
            else return sum;
        }
    }
}
