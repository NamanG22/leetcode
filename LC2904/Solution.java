public class Solution {
    public boolean compare(int resStarting, int i, int j, String s){
        for(int k=0;k+i<=j;k++){
            if(s.charAt(i+k)=='0' && s.charAt(resStarting+k)=='1') return true;
            if(s.charAt(i+k)=='1' && s.charAt(resStarting+k)=='0') return false;
        }
        return false;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int i = 0;
        int j = 0;
        int kc = 0;
        int len = s.length()+1;
        int resStarting = 0;
        int resEnding = -1;
        while(j<s.length()){
            if(s.charAt(j)=='1') kc++;
            if(kc>k){
                while(true){
                    if(s.charAt(i)=='1'){
                        if(kc==k) break;
                        kc--;
                    }
                    i++;
                }
            }
            if(kc==k){
                while(s.charAt(i)=='0') i++;
                if(j-i+1<len){
                    len = j-i+1;
                    resStarting = i;
                    resEnding = j;
                }
                else if(j-i+1==len){
                    if(compare(resStarting, i, j, s)){
                        resStarting = i;
                        resEnding = j;
                    }
                }
            }
            j++;
        }
        return s.substring(resStarting,resEnding+1);
    }
}
