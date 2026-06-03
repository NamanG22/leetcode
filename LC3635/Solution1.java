package LeetCode.LC3635;

public class Solution1 {
    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {
        int mld = Integer.MAX_VALUE;
        int mwd = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<ls.length;i++){
            mld = Math.min(mld, ls[i]+ld[i]);
        }
        for(int i=0;i<ws.length;i++){
            mwd = Math.min(mwd, ws[i]+wd[i]);
            res = Math.min(res,Math.max(ws[i],mld)+wd[i]);
        }
        for(int i=0;i<ls.length;i++){
            res = Math.min(res,Math.max(ls[i],mwd)+ld[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] landStartTime = {1,2,3};
        int[] landDuration = {4,5,6};
        int[] waterStartTime = {7,8,9};
        int[] waterDuration = {10,11,12};
        System.out.println(solution1.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }
}
