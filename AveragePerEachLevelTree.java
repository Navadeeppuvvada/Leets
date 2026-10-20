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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resultL= new ArrayList<>();
        if(root==null)
          return resultL;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
             double averageL=0;
            for(int i=0;i<size;i++){
                TreeNode currentV=q.poll();
                averageL+=currentV.val;
                if(currentV.left!=null){
                    q.offer(currentV.left);
                }
                if(currentV.right!=null){
                    q.offer(currentV.right);
                }
            }
            averageL/=size;
           resultL.add(averageL);
        }
      return resultL;
    }
}


Time and Space Complexity
Time Complexity: \(O(n)\)
- We visit each node exactly once using level-order traversal (BFS).
- Processing each node and adding its children to the queue takes \(O(1)\) time.
- Therefore, for \(n\) nodes, the total time complexity is \(O(n)\).
Space Complexity: \(O(n)\)
- The queue can hold up to \(O(n)\) nodes in the worst case.
- The result list stores one average per level, requiring at most \(O(n)\) space.
- Therefore, the overall space complexity is \(O(n)\).
How the code works
1. Initialize: Create a result list and a queue, then insert the root node.
2. Level-order traversal: Use BFS to process nodes level by level. Store the current queue size to determine how many nodes belong to the current level.
3. Calculate the average: Sum the values of all nodes at that level and divide by the level's node count.
4. Store the result: Add the average to the result list and repeat until the queue is empty.
5. Return: Return the list containing the average of each level.
