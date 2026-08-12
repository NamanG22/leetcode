import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        long arr[] = new long[nums.length];
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        for(Map.Entry<Integer,ArrayList<Integer>> e:map.entrySet()){
            int key = e.getKey();
            ArrayList<Integer> ll = e.getValue();
            long arr1[] = new long[ll.size()];
            arr1[0] = ll.get(0);
            for(int i=1;i<ll.size();i++){   
                arr1[i] = arr1[i-1]+ll.get(i);
            }
            for(int i=0;i<ll.size();i++){   
                long res = 0;
                res-=((long)ll.get(i)*(long)(arr1.length-1-i));
                res-=arr1[i];
                res+=((long)ll.get(i)*(long)(i+1));
                res+=(arr1[arr1.length-1]-arr1[i]);
                arr[ll.get(i)]=res;
            }
        }
        return arr;
    }
}
