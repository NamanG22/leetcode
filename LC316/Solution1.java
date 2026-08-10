import java.util.Arrays;
import java.util.Stack;

public class Solution1 {
    public String removeDuplicateLetters(String s) {
        int lastOcc[] = new int[26];
        boolean added[] = new boolean[26];
        Arrays.fill(lastOcc,-1);
        for(int i=0;i<s.length();i++){
            lastOcc[s.charAt(i)-'a']=i;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(i);
                added[s.charAt(i)-'a'] = true;
            }
            else{
                if(!added[s.charAt(i)-'a']){
                    while(!stack.isEmpty() && s.charAt(stack.peek())>s.charAt(i) && lastOcc[s.charAt(stack.peek())-'a']>i){
                        added[s.charAt(stack.pop())-'a'] = false;
                    }
                    stack.push(i);
                    added[s.charAt(i)-'a'] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(s.charAt(stack.pop()));
        }
        return sb.reverse().toString();
    }
}
