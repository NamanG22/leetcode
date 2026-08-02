import java.util.HashMap;

public class Solution {
    public boolean rec(int arr[], int s, int e, int alice, int bob, HashMap<Integer,HashMap<Integer,Boolean>> map){
        if(s>e) return alice>=bob;
        // if(map.containsKey(s) && map.get(s).containsKey(alice)) return map.get(s).get(alice);
        boolean res = rec(arr,s+2,e,alice+arr[s],bob+arr[s+1],map);
        // if(!map.containsKey(s)) map.put(s,new HashMap<>());
        // map.get(s).put(alice,res);
        return res;
    }
    public boolean rec2(int arr[], int s, int e, int alice, int bob, HashMap<Integer,HashMap<Integer,Boolean>> map){
        if(s>e) return alice>=bob;
        // if(map.containsKey(s) && map.get(s).containsKey(alice)) return map.get(s).get(alice);
        boolean res = rec(arr,s+1,e-1,alice+arr[e],bob+arr[s],map);
        // if(!map.containsKey(s)) map.put(s,new HashMap<>());
        // map.get(s).put(alice,res);
        return res;
    }
    public boolean rec1(int arr[], int s, int e, int alice, int bob, HashMap<Integer,HashMap<Integer,Boolean>> map){
        if(s>e) return alice>=bob;
        if(map.containsKey(s) && map.get(s).containsKey(alice)) return map.get(s).get(alice);
        boolean res = rec(arr,s+1,e-1,alice+arr[s],bob+arr[e],map) || rec(arr,s,e-2,alice+arr[e],bob+arr[e-1],map);
        if(!map.containsKey(s)) map.put(s,new HashMap<>());
        map.get(s).put(alice,res);
        return res;
    }
    public boolean stoneGame(int[] piles) {
        return rec(piles,0,piles.length-1,0,0,new HashMap<>()) || rec1(piles,0,piles.length-1,0,0,new HashMap<>()) || rec2(piles,0,piles.length-1,0,0,new HashMap<>());
    }
}
