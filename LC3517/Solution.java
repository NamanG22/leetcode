public class Solution {
    public String smallestPalindrome(String s) {
        int hash[] = new int[26];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }
        int mid = -1;
        for(int i=0;i<26;i++){
            int half = hash[i]/2;
            if(hash[i]%2!=0) mid = i;
            for(int j=0;j<half;j++){
                sb.append((char)('a'+i));
            }
        }
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.reverse();
        if(mid!=-1) sb.append((char)('a'+mid));
        sb.append(sb2);
        return sb.toString();
    }
}
