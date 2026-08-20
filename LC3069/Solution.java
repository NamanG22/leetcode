import java.util.ArrayList;

public class Solution {
    public int[] resultArray(int[] nums) {
        int res[] = new int[nums.length];
        ArrayList<Integer> ll = new ArrayList<>(nums.length/2+1);
        int i = 0;
        res[i++] = nums[0];
        ll.add(nums[1]);
        for(int j=2;j<nums.length;j++){
            if(res[i-1]>ll.get(ll.size()-1)) res[i++] = nums[j];
            else ll.add(nums[j]);
        }
        for(int j:ll){
            res[i++] = j;
        }
        return res;
    }
}
