import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        boolean hash[] = new boolean[101];
        List<Integer> ll = new ArrayList<>();
        int min = 101, max = 0;
        for(int i:nums){
            hash[i]=true;
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        int i=min+1,j=max-1;
        for(;i<=j;i++){
            if(!hash[i]) ll.add(i);
        }
        return ll;
    }
}
