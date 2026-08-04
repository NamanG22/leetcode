public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int freqOfArr[] = new int[2001];
        for(int i:arr){
            freqOfArr[i+1000]++;
        }
        boolean freqOfHash[] = new boolean[1001];
        for(int i:freqOfArr){
            if(i==0) continue;
            if(freqOfHash[i]) return false;
            freqOfHash[i]=true;
        }
        return true;
    }
}
