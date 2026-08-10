import java.util.ArrayList;

public class Solution {
    String res;
    public String buildString(String s, boolean str[]){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length;i++){
            if(str[i]) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public void rec(ArrayList<Integer> hash[], int index, boolean str[], String s){
        if(index==str.length){
            String newString = buildString(s,str);
            if(res.compareTo(newString)>0){
                res = new String(newString);
            }
            return;
        }
        for(int i=0;i<hash[index].size();i++){
            str[hash[index].get(0)] = true;
            rec(hash,index+1,str,s);
            str[hash[index].get(0)] = false;
        }
        return;
    }
    public String removeDuplicateLetters(String s) {
        ArrayList<Integer> hash[] = new ArrayList[26];
        for(int i=0;i<26;i++){
            hash[i] = new ArrayList<>();
        }
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a'].add(i);
        }
        boolean str[] = new boolean[s.length()];
        System.out.println(res);
        rec(hash,0,str,s);
        System.out.println(res);
        return res;
    }
}
