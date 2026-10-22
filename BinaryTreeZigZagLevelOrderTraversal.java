import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        q.offer(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                level.add(current.val);

                if (current.left != null) {
                    q.offer(current.left);
                }

                if (current.right != null) {
                    q.offer(current.right);
                }
            }

            if (reverse) {
                Collections.reverse(level);
            }

            result.add(level);
            reverse = !reverse;
        }

        return result;
    }
}


Time Complexity: (O(N))
- Each node is visited exactly once during level-order traversal.
- Reversing each level takes time proportional to the number of nodes at that level.
- Therefore, the overall time complexity is (O(N)), where (N) is the total number of nodes.
Space Complexity: (O(N))
- The queue can store up to (O(N)) nodes in the worst case.
- The result list stores all (N) node values.
- Therefore, the overall space complexity is (O(N)), including the output space.
  
Few lines about the code
- Uses BFS (Breadth-First Search) with a queue to traverse the tree level by level.
- Processes all nodes at the current level using size = q.size().
- Uses a boolean variable reverse to alternate the traversal direction of each level.
- Uses Collections.reverse(level) to reverse every alternate level.
- Returns an empty list if the root is null.
