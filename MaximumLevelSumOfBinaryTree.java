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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list= new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            int levelSum=0;
            for(int i=0;i<size;i++){
                TreeNode current= q.poll();
                levelSum+=current.val;
                if(current.left!=null){
                    q.offer(current.left);
                }
                if(current.right!=null){
                    q.offer(current.right);
                }
                
            }
            list.add(levelSum);
        }
        int max=Collections.max(list);
        int index= list.indexOf(max)+1;
        return index;
    }
}


. Approach
- Use a queue to perform Breadth-First Search (BFS) level by level.
- For each level, calculate the sum of all node values.
- Store each level's sum in a list.
- Find the maximum sum using Collections.max().
- Return the 1-based index of the first occurrence of the maximum sum.

Time Complexity: O(n) — The solution traverses each node exactly once using BFS and processes every node to calculate its level sum.

Space Complexity: O(n) — The queue stores nodes at each level, and the list stores the sum of each level. In the worst case, the total auxiliary space is linear in the number of nodes.
