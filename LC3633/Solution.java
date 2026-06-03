package LeetCode.LC3633;

public class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minLandRideFinishTime = Integer.MAX_VALUE;
        int minWaterRideFinishTime = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            minLandRideFinishTime = Math.min(minLandRideFinishTime, landStartTime[i]+landDuration[i]);
        }
        for(int i=0;i<waterStartTime.length;i++){
            minWaterRideFinishTime = Math.min(minWaterRideFinishTime, waterStartTime[i]+waterDuration[i]);
        }
        for(int i=0;i<landStartTime.length;i++){
            if(landStartTime[i]>=minWaterRideFinishTime){
                res = Math.min(res,landStartTime[i]+landDuration[i]);
            }
            else{
                res = Math.min(res,minWaterRideFinishTime+landDuration[i]);
            }
        }
        for(int i=0;i<waterStartTime.length;i++){
            if(waterStartTime[i]>=minLandRideFinishTime){
                res = Math.min(res,waterStartTime[i]+waterDuration[i]);
            }
            else{
                res = Math.min(res,minLandRideFinishTime+waterDuration[i]);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] landStartTime = {1,2,3};
        int[] landDuration = {4,5,6};
        int[] waterStartTime = {7,8,9};
        int[] waterDuration = {10,11,12};
        System.out.println(solution.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }
}
