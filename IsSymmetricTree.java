
 // * Definition for a binary tree node.
 // * public class TreeNode {
 // *     int val;
 // *     TreeNode left;
 // *     TreeNode right;
 // *     TreeNode() {}
 // *     TreeNode(int val) { this.val = val; }
 // *     TreeNode(int val, TreeNode left, TreeNode right) {
 // *         this.val = val;
 // *         this.left = left;
 // *         this.right = right;
 // *     }
 // * }
 
class Solution {
    public boolean isSymmetric(TreeNode root) {
       return isSymmetric1(root.left,root.right);
    }
    public boolean isSymmetric1(TreeNode left, TreeNode right){
        if(left==null && right==null)
          return true;
        if(left==null || right==null)
          return false;
         if(left.val!=right.val)
           return false; 
        return  isSymmetric1(left.left,right.right) &&  isSymmetric1(left.right,right.left);
    }
}

Time Complexity (TC): (O(n))
Each node is visited at most once to check whether the left and right subtrees are mirror images.
Space Complexity (SC): (O(h))
The recursive calls use stack space proportional to the height of the tree (h).
- Balanced tree: (O(log n))
- Skewed tree: (O(n))
  
Code Explanation :
- Checks whether both nodes are null; if so, returns true.
- If only one node is null, returns false.
- If the node values differ, returns false.
- Recursively compares the left subtree's left child with the right subtree's right child, and vice versa.
- Returns true only if both comparisons are symmetric.
Approach: Recursion — Mirror comparison of the binary tree.
