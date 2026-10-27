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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
       return list;
    }
}

Time Complexity (TC): (O(n))
Each node in the binary tree is visited exactly once.
Space Complexity (SC): (O(n))
The result list stores all (n) node values. The recursive call stack can take (O(h)) space, where (h) is the tree height. Overall auxiliary space, excluding the output list, is (O(h)).

  Code Explanation
- If root == null, return an empty list.
- Recursively traverse the left subtree.
- Add the current node's value to the list.
- Recursively traverse the right subtree.
- This follows Inorder Traversal: Left → Root → Right.
