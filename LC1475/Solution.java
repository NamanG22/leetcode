import java.util.Stack;

public class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && prices[i]<=prices[stack.peek()]){
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
