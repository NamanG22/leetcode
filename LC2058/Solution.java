/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode node) {
        int res[] = new int[2];
        res[0]=100001;
        res[1]=0;
        int prevCritical = -1;
        int prev = node.val;
        node = node.next;
        int i = 1;
        while(node!=null){
            int curr = node.val;
            if(node.next!=null){
                if(prev<curr && curr>node.next.val){
                    if(prevCritical==-1) prevCritical = i;
                    else{
                        res[0] = Math.min(res[0],i-prevCritical);
                        res[1] += (i-prevCritical);
                        prevCritical = i;
                    }
                }
                else if(prev>curr && curr<node.next.val){
                    if(prevCritical==-1) prevCritical = i;
                    else{
                        res[0] = Math.min(res[0],i-prevCritical);
                        res[1] += (i-prevCritical);
                        prevCritical = i;
                    }
                }
            }
            i++;
            node = node.next;
            prev = curr;
        }
        if(res[1]==0) res[1]=-1;
        if(res[0]==100001) res[0]=-1;
        return res;
    }
}
