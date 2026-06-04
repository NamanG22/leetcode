public class Solution1{
    public int totalWaviness(int num1, int num2) {
        int hash[] = new int[100001];
        int res = 0;
        for(int i=Math.max(101,num1);i<=num2;i++){
            int count = 0;
            if(hash[i/10]!=0){
                count+=hash[i/10];
                int last = i%10;
                int secondLast = (i%100)/10;
                int thirdLast = (i%1000)/100;
                if(last<secondLast && secondLast>thirdLast) count++;
                else if(last>secondLast && secondLast<thirdLast) count++;
            }
            else{
                int ii = i;
                while(true){
                    int last = ii%10;
                    int secondLast = (ii%100)/10;
                    int thirdLast = (ii%1000)/100;
                    if(last<secondLast && secondLast>thirdLast) count++;
                    else if(last>secondLast && secondLast<thirdLast) count++;
                    ii/=10;
                    if(ii<=100) break;
                }
            }
            res+=count;
            hash[i]=count;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.totalWaviness(100, 100));
    }
}