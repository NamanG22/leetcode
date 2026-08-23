import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int hash[] = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        hash[0]=-1;
        for(int i=1;i<2*nums.length;i++){
            if(i<nums.length) hash[i]=-1;
            while(!stack.isEmpty() && nums[i%nums.length]>nums[stack.peek()]){
                hash[stack.pop()] = nums[i%nums.length];
            }
            stack.push(i%nums.length);
        }
        return hash;
    }
}
