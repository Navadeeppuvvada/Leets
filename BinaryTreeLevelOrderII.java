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
 import java.util.*;
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       Queue<TreeNode> q= new LinkedList<>();
       List<List<Integer>> result= new ArrayList<>();
       if(root==null)
          return result;
       q.offer(root);
       while(!q.isEmpty()){
        int size=q.size();
        List<Integer> level= new ArrayList<>();
        for(int i=0;i<size;i++){
            TreeNode current=q.poll();
            level.add(current.val);
            if(current.left!=null){
                q.offer(current.left);
            }
            if(current.right!=null){
                q.offer(current.right);
            }
            }
          result.add(0,level);
       } 
       return result;
          }
}


Time Complexity: O(n²) in the worst case
- Each of the (n) nodes is visited exactly once, taking (O(n)).
- result.add(0, level) inserts each level at the beginning of an ArrayList, which may require shifting existing elements. In the worst case, this takes (O(n^2)) overall.
Space Complexity: O(n)
- The queue stores nodes at each level, requiring at most (O(n)) space.
- The result list stores all (n) node values, requiring (O(n)) space.
Note: If you use a LinkedList for result instead of an ArrayList, inserting at the beginning is (O(1)), making the overall time complexity O(n).

  This code performs Bottom-Up Level Order Traversal of a binary tree using BFS (Breadth-First Search).
- Uses a queue to traverse the tree level by level.
- Processes each level separately and stores node values in a list.
- Adds each level at index 0 of the result list to reverse the level order.
- Returns the final list, starting from the bottom level and ending at the root.
- If the tree is empty (root == null), it returns an empty list.
  
