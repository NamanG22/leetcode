import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,boolean[]> map = new HashMap<>();
        for(int i=0;i<reservedSeats.length;i++){
            if(!map.containsKey(reservedSeats[i][0])) map.put(reservedSeats[i][0],new boolean[11]);
            map.get(reservedSeats[i][0])[reservedSeats[i][1]] = true;
        }
        int count = 2*(n-map.size());
        for(Map.Entry<Integer,boolean[]> e:map.entrySet()){
            boolean[] arr = e.getValue();
            boolean first = true, second = true, third = true;
            if(arr[2] || arr[3]) first = false;
            if(arr[4] || arr[5]){
                first = false;
                second = false;
            }
            if(arr[6] || arr[7]){
                third = false;
                second = false;
            }
            if(arr[8] || arr[9]) third = false;
            if(first && third) count+=2;
            else if(first || third) count++;
            else if(second) count++;
        }
        return count;
    }
}
