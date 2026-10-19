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
 import java.util.LinkedList;
 import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)
          return list;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode current =q.poll();
                level.add(current.val);
                if(current.left!=null){
                    q.offer(current.left);
                }
                if(current.right!=null){
                    q.offer(current.right);
                }
            }
            list.add(level);
        }
   return list;
}
}

Time Complexity: (O(n)) — Each node is visited and processed exactly once, where (n) is the total number of nodes.
Space Complexity: (O(n)) — The queue can hold up to (O(n)) nodes, and the result list stores all (n) node values.

  Explanation :- 
  I took Queue interface and implemented it through LinkedList since i was working with tree {Nodes} related data . I chooose Queue because of its principle FIFO .
  and then i checked to ensure that the root is empty or not to ensure that the tree contain data or not if not i just returned the empty list .
  i added root initially . i wrote while loop to run until my queue gets empty .
  I took variable sizee to check the size of queue . and i wrote the for loop to traverse to the end of the queue size and then i just removed root by using poll() method and stored it in another variable .
  After that i checked does the root have lift or right childs if they are existed then they will be added into the queue in the FIFO principle .
  The rest of the operation will be continued like this until my queue gets ended and all the elements in the tree gets traversed successfully in level Order .
