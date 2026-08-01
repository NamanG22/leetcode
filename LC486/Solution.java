public class Solution {
    public boolean rec(int arr[], int s, int e, int scoreA, int scoreB, boolean isATurn){
        if(s>e) return scoreA>=scoreB;
        if(isATurn) return rec(arr,s+1,e,scoreA+arr[s],scoreB,false) || rec(arr,s,e-1,scoreA+arr[e],scoreB,false);
        return rec(arr,s+1,e,scoreA,scoreB+arr[s],true) && rec(arr,s,e-1,scoreA,scoreB+arr[e],true);
        
    }
    public boolean predictTheWinner(int[] nums) {
        return rec(nums,0,nums.length-1,0,0,true);
    }
}
