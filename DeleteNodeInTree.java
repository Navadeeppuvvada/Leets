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
    private TreeNode findMin(TreeNode node) {
    while (node.left != null) {
        node = node.left;
    }
    return node;
}
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
           return null;
        if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        else if(root.val>key){
            root.left=deleteNode(root.left,key);
        }
        else{
            if(root.left==null&& root.right==null){
                return null;
            }
            if(root.left==null)
               return root.right;
            if(root.right==null)
               return root.left;
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }
}


Time Complexity (TC)
O(h) — where (h) is the height of the BST.
- Searching for the node takes (O(h)).
- Finding the inorder successor takes (O(h)) in the worst case.
- For a balanced BST: O(log n).
- For a skewed BST: O(n).
Space Complexity (SC)
O(h) — due to recursive function calls.
- Balanced BST: O(log n).
- Skewed BST: O(n).
  
Code Explanation
1. Search: Recursively search for the node using BST properties.
2. No children: If the node is a leaf, return null.
3. One child: Return the existing child to replace the deleted node.
4. Two children: Find the inorder successor (smallest node in the right subtree), copy its value, and delete the successor.
5. Return root: Return the updated root after deletion.
Key point: The inorder successor ensures the BST property is maintained after deleting a node.
