import java.util.HashMap;

public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0,j=0;
        int max = 0;
        while(j<nums.length){
            int curr = map.getOrDefault(nums[j],0);
            map.put(nums[j],curr+1);
            if(curr==k){
                max = Math.max(max,j-i);
                while(i<j){
                    map.put(nums[i],map.get(nums[i])-1);
                    if(nums[i++]==nums[j]) break;
                }
            }
            j++;
        }
        max = Math.max(max,j-i);
        return max;
    }
}
