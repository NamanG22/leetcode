class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int hash[] = new int[52];
        int hash2[] = new int[52];
        int unique = 0;
        int curr = 0;
        int min = s.length()+1;
        int start = -1;
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            int index = c<'a'?c-'A':c-'a'+26;
            if(hash[index]==0) unique++;
            hash[index]++;
        }
        for(int i=0,j=0;i<s.length();i++){
            char c = s.charAt(i);
            int index = c<'a'?c-'A':c-'a'+26;
            hash2[index]++;
            if(hash2[index]==hash[index]) curr++;
            while(j<i){
                char cc = s.charAt(j);
                int index1 = cc<'a'?cc-'A':cc-'a'+26;
                if(hash2[index1]-1<hash[index1]){
                    break;
                }
                hash2[index1]--;
                j++;
            }
            if(curr==unique){
                if(min>i-j+1){
                    min = i-j+1;
                    start = j;
                }
            }
        }
        if(start==-1) return "";
        return s.substring(start,start+min);
    }
}
