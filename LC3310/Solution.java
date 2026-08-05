import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        HashMap<Integer,HashSet<Integer>> map1 = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> map2 = new HashMap<>();
        HashSet<Integer> suspicious = new HashSet<>();
        List<Integer> remainingNodes = new ArrayList<>();
        boolean flag = false;
        suspicious.add(k);
        for(int i=0;i<invocations.length;i++){
            if(!map1.containsKey(invocations[i][0])) map1.put(invocations[i][0],new HashSet<>());
            if(!map2.containsKey(invocations[i][1])) map2.put(invocations[i][1],new HashSet<>());
            map1.get(invocations[i][0]).add(invocations[i][1]);
            map2.get(invocations[i][1]).add(invocations[i][0]);
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(k);
        while(!q.isEmpty()){
            int curr = q.poll();
            if(!map1.containsKey(curr)) continue;
            for(int i:map1.get(curr)){
                if(!suspicious.contains(i)){
                    suspicious.add(i);
                    q.offer(i);
                }
            }
        }
        for(int i:suspicious){
            if(!map2.containsKey(i)) continue;
            for(int j:map2.get(i)){
                if(!suspicious.contains(j)){
                    flag = true;
                    break;
                }
            }
        }
        if(!flag){
            for(int i=0;i<n;i++){
                if(!suspicious.contains(i)) remainingNodes.add(i);
            }
        }
        else{
            for(int i=0;i<n;i++){
                remainingNodes.add(i);
            }
        }
        return remainingNodes;
    }
}
