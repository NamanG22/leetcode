public class Solution1 {
    public int minimumCost(int[] cost) {
        int hash[] = new int[101];
        int count = 0;
        int res = 0;
        for(int i=0;i<cost.length;i++){
            hash[cost[i]]++;
        }
        for(int i=100;i>=0;i--){
            if(count==1){
                if(hash[i]>1){
                    hash[i]-=2;
                    res+=i;
                    count = 0;
                }
                else if(hash[i]>0){
                    hash[i]--;
                    res+=i;
                    count=2;
                }
            }
            else if(count==2){
                if(hash[i]>0){
                    hash[i]--;
                    count = 0;
                }
            } 
            res+=(hash[i]/3)*2*i + (hash[i]%3)*i;
            count = (count+(hash[i]%3))%3;
            // System.out.println(i+" "+res+" "+count);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] cost = {1,2,3,4,5,6};
        System.out.println(solution1.minimumCost(cost));
    }
}
