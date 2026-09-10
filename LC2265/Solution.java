/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] rec(TreeNode root){
        int left[] = {0,0,0};
        int right[] = {0,0,0};
        if(root.left!=null) left = rec(root.left);
        if(root.right!=null) right = rec(root.right);
        int res[] = new int[3];
        int avgSum = left[1]+right[1]+root.val;
        int nodes = left[2]+right[2]+1;
        int avg = avgSum/nodes;
        res[0] = left[0]+right[0]+(avg==root.val?1:0);
        res[1] = avgSum;
        res[2] = nodes;
        return res;
    }
    public int averageOfSubtree(TreeNode root) {
        return rec(root)[0];
    }
}
