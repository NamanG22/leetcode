package LeetCode.LC406;

import java.util.Arrays;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int res[][] = new int[people.length][2];
        boolean set[] = new boolean[people.length];
        Arrays.sort(people,(a,b)->a[0]-b[0]);
        for(int i=0;i<people.length;i++){
            int h = people[i][0];
            int k = people[i][1];
            int kk = k;
            for(int j=0;j<res.length;j++){
                if(!set[j]){
                    if(kk==0){
                        res[j][0]=h;
                        res[j][1]=k;
                        set[j] = true;
                        break;
                    }
                    else kk--;
                }
                else if(res[j][0]>=h) kk--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res = solution.reconstructQueue(people);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }
}
