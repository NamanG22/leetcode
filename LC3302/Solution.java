import java.util.Arrays;

class Solution {
    public int[] validSequence(String word1, String word2) {
        char ch1[] = word1.toCharArray();
        char ch2[] = word2.toCharArray();
        int m = ch1.length;
        int n = ch2.length;
        int suffix[] = new int[n];
        int res[] = new int[n];
        Arrays.fill(suffix,-1);
        for(int i=m-1,j=n-1;i>=0 && j>=0;i--){
            if(ch1[i]==ch2[j]) suffix[j--]=i;
        }
        System.out.println("suffix: "+Arrays.toString(suffix));
        boolean resFound = false;
        int j=0;
        for(int i=0;i<m && j<n;i++){
            if(ch1[i]==ch2[j]) res[j++]=i;
            else{
                if(j==n-1 || suffix[j+1]>i){
                    resFound = true;
                    res[j++]=i;
                    for(int k=i+1;j<n;k++){
                        if(ch1[k]==ch2[j]) res[j++]=k;
                    }
                    break;
                }
            }
        }
        if(j==n) return res;
        if(!resFound) return new int[0];
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.validSequence("ccbccccbcc", "b")));
        // System.out.println(Arrays.toString(s.validSequence("abc", "ab")));
        // System.out.println(Arrays.toString(s.validSequence("bacdc", "abc")));
        // System.out.println(Arrays.toString(s.validSequence("ghhgghhhhhha", "gga")));
        // System.out.println(Arrays.toString(s.validSequence("abfdfeeaddccbbddfddcddaebdecaaebbebceaddcbbefdfebceefffeffeeeefeffeeefeefffreeeeffeeefeeffeeffeeeffeccbabbdcafdebdccfabbbcabfbeaecbfabfebaeedcabdceded", "eefffeffeeeefeffeeefeefffeeeeeffeeefeeffeeffeeeffe")));
    }
}
