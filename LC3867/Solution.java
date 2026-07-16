import java.util.Arrays;

public class Solution {
    public int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max = 0;
        long res = 0;
        int prefixGcd[] = new int[n];
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
            prefixGcd[i] = gcd(max,nums[i]);
        }
        Arrays.sort(prefixGcd);
        int left = 0, right = n-1;
        while(left<right){
            res+=gcd(prefixGcd[left++],prefixGcd[right--]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.gcdSum(new int[]{2, 6, 4}));
        System.out.println(solution.gcdSum(new int[]{3, 6, 2, 8}));
    }
}
