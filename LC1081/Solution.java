public class Solution {
    public String smallestSubsequence(String s) {
        char ch[] = s.toCharArray();
        int hash[] = new int[26];
        boolean lastOcc[] = new boolean[ch.length];
        StringBuilder sb = new StringBuilder();
        for(int i=ch.length-1;i>=0;i--){
            hash[ch[i]-'a']++;
            if(hash[ch[i]-'a']==1) lastOcc[i] = true;
        }
        int minIn = -1;
        for(int i=0;i<ch.length;i++){
            if(hash[ch[i]-'a']>0){
                if(minIn==-1 || ch[i]<ch[minIn]) minIn = i;
            }
            else continue;
            if(lastOcc[i]==false) continue;
            sb.append(ch[minIn]);
            i = minIn;
            hash[ch[minIn]-'a']=0;
            minIn = -1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestSubsequence("bcabc"));
        System.out.println(solution.smallestSubsequence("cbacdcbc"));
    }
}
