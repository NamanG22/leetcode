import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int hash[] = new int[nums2.length];
        int res[] = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        stack.push(0);
        hash[0]=-1;
        map.put(nums2[0],0);
        for(int i=1;i<nums2.length;i++){
            hash[i]=-1;
            while(!stack.isEmpty() && nums2[i]>nums2[stack.peek()]){
                hash[stack.pop()] = i;
            }
            stack.push(i);
            map.put(nums2[i],i);
        }
        for(int i=0;i<nums1.length;i++){
            int index = hash[map.get(nums1[i])];
            if(index!=-1) res[i] = nums2[index];
            else res[i]=-1;
        }
        return res;
    }
}
