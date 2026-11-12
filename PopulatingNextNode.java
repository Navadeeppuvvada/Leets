/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
     if(root==null)
        return null;

    Node MaxRight=root;
    while(MaxRight.left!=null){
        Node current= MaxRight;
        while(current!=null){
        current.left.next=current.right;
        if(current.next!=null){
            current.right.next=current.next.left;
        }
        current = current.next;       
    
        }
       MaxRight=MaxRight.left; 
    }   
    return root;
    }
}


We are connecting each node to its immediate right node at the same level using the next pointer. We traverse the tree level by level without using a queue or recursion.
  First, we connect the left child to its right sibling, then connect the right child to the left child of the next parent. We use two pointers, 
  MaxRight and current, to traverse each level efficiently.

Time Complexity: O(N)
Space Complexity: O(1) (Auxiliary Space)
