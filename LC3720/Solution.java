public class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int hash[] = new int[26];
        int hash2[] = new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
            hash2[s.charAt(i)-'a']++;
        }
        char charr[] = new char[s.length()];
        int k = 0;
        boolean firstDiff = false;
        q:for(int i=0;i<target.length();i++){
            char ch = target.charAt(i);
            if(!firstDiff){
                for(int j=ch-'a';j<26;j++){
                    if(hash[j]-->0){
                        charr[k++] = (char)(j+'a');
                        if(j>ch-'a') firstDiff = true;
                        continue q;
                    }
                }
                break q;
            }
            else{
                for(int j=0;j<26;j++){
                    if(hash[j]-->0){
                        charr[k++] = (char)(j+'a');
                        break;
                    }
                }
            }
        }
        if(!firstDiff){
            boolean lastLexo = true;
            int i=s.length()-2;
            if(i==-1) return "";
            if(k<s.length()){
                i = k-1;
                lastLexo = false;
            }
            else{
                for(;i>=0;i--){
                    if(charr[i]<charr[i+1]){
                        lastLexo = false;
                        break;
                    }
                }
            }
            if(i==-1) return "";
            if(lastLexo) return "";
            else{
                for(int j=0;j<i;j++){
                    hash2[charr[j]-'a']--;
                }
                while(true){
                    boolean flag = false;
                    for(int j=charr[i]-'a'+1;j<26;j++){
                        if(hash2[j]>0){
                            hash2[j]--;
                            charr[i++] = (char)(j+'a');
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        if(i==0) return "";
                        i--;
                        hash2[charr[i]-'a']++;
                        continue;
                    }
                    for(;i<s.length();i++){
                        for(int j=0;j<26;j++){
                            if(hash2[j]>0){
                                hash2[j]--;
                                charr[i]=(char)(j+'a');
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        return new String(charr);
    }
}
