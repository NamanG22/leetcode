public class Solution {
    public int maximumLengthSubstring(String s) {
        int hash[] = new int[26];
        int max = 0;
        int i=0,j=0;
        for(;j<s.length();j++){
            hash[s.charAt(j)-'a']++;
            if(hash[s.charAt(j)-'a']==3){
                max = Math.max(max,j-i);
                while(hash[s.charAt(j)-'a']==3){
                    hash[s.charAt(i++)-'a']--;
                }
            } 
        }
        max = Math.max(max,j-i);
        return max;
    }
}
