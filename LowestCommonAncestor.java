/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p || root==q)
         {
            return root;
         }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
         if(left!=null && right!=null){
            return root;
         }
         return left==null ? right:left;
    }
}

Lowest Common Ancestor (Binary Tree)
Description
The algorithm uses Recursive DFS (Depth First Search) to find the Lowest Common Ancestor (LCA) of two given nodes p and q in a binary tree.
1. If the root is null, return null because no node exists.
2. If the current root is equal to p or q, return the root itself.
3. Recursively search for p and q in the left and right subtrees.
4. If both left and right are not null, the current root is the Lowest Common Ancestor.
5. Otherwise, return the non-null result (left or right).
  
Time Complexity (TC)
O(N)
- In the worst case, we visit every node in the binary tree.
- Where N is the total number of nodes.
  
Space Complexity (SC)
O(H)
- Space is used by the recursive call stack.
- Where H is the height of the binary tree.
- Balanced tree: O(log N).
- Skewed tree: O(N).
