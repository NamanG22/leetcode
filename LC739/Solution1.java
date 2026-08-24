public class Solution1 {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        int hash[] = new int[101];
        hash[arr[n-1]] = n-1;
        for(int i=n-2;i>=0;i--){
            int min = 100001;
            for(int j=arr[i]+1;j<=100;j++){
                if(hash[j]!=0) min = Math.min(min,hash[j]);
            }
            if(min!=100001) res[i] = min-i;
            hash[arr[i]] = i;
        }
        return res;
    }
}
