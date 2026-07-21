public class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        char ch[] = s.toCharArray();
        int n = ch.length;
        int left = 0;
        int right = n-1;
        int res = 0;
        while(left<n){
            if(ch[left]=='1'){
                res++;
                left++;
            }
            else break;
        }
        while(left<=right){
            if(ch[right]=='1'){
                res++;
                right--;
            }
            else break;
        }
        int j = left;
        int max = 0;
        while(j<=right){
        int firstZeroes = 0;
        int endZeroes = 0;
            while(j<=right){
                if(ch[j]=='0'){
                    j++;
                    firstZeroes++;
                }
                else break;
            }
            boolean flag = false;
            while(j<=right){
                if(ch[j]=='1'){
                    j++;
                    res++;
                    flag = true;
                }
                else break;
            }
            int k = j;
            while(k<=right){
                if(ch[k]=='0'){
                    k++;
                    endZeroes++;
                }
                else break;
            }
            if(flag) max = Math.max(max,firstZeroes+endZeroes);
        }
        return res+max;
    }
}
