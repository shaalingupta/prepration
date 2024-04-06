package dsa;

import java.util.*;

/**
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 *
 * You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
 *
 * We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [4,2,5,1,3]
 *
 *
 * Output: [1,2,3,4,5]
 *
 * Explanation: The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.
 *
 * Example 2:
 *
 * Input: root = [2,1,3]
 * Output: [1,2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 * All the values of the tree are unique.
 */
public class ConvertBinarySearchTreetoSortedDoublyLinkedList {

    Node prev = null;
    public Node treeToDoublyListUsingDFS(Node root) {
        if(root == null){
            return null;
        }
        Node temp = new Node(); // jaha se chalu kiya
        prev = temp; // dfs ko call krne k bad last me yeh update ho jaega, basically yeh last nod of tree hoga
        DFS(root);

        Node head = temp.right;
        temp.right = null; // remove this dummy node

        head.left = prev; // make it circular
        prev.right = head;

        return head;
    }

    public void DFS(Node root){
        if(root == null){
            return;
        }

        DFS(root.left); //inorder

        prev.right = root; //use logic of linkedlinst of attaching a new node and move to next node
        root.left = prev;
        prev = root;

        DFS(root.right); //inorder
    }


    public Node treeToDoublyListUsingStack(Node root){
        Stack<Node> st = new Stack<>();
        addAllLeftNodes(root, st);

        Node temp = new Node();
        Node prev = temp;

        while (!st.isEmpty()){
            Node curr = st.pop();

            prev.right = curr;
            curr.left = prev;
            prev = curr;

            addAllLeftNodes(root.right, st);
        }

        Node head = temp.right;
        temp.right = null;

        prev.right = head;
        head.left = prev;

        return head;
    }

    public void addAllLeftNodes(Node curr, Stack<Node> st){
        while(curr != null){
            st.push(curr);
            curr = curr.left;
        }
    }

    /**
     * Morris Traversal
     * Space O(1)
     *
     * @param root
     */
    public Node treeToDoublyList(Node root){

        if(root == null){
            return null;
        }

        Node temp = new Node();
        Node prev = temp;
        Node curr = root;

        while(curr != null){
            if (curr.left == null){

                prev.right = curr;
                curr.left = prev;
                prev = curr;

                curr = curr.right;
            }else{
                Node rightMostElement = getRightMostNode(curr.left, curr);

                if (rightMostElement.right == null){
                    rightMostElement.right = curr;
                    curr = curr.left;
                }else{

                    rightMostElement.right = null;

                    prev.right = curr;
                    curr.left = prev;
                    prev = curr;

                    curr = curr.right;
                }
            }
        }

        Node head = temp.right;
        temp.right = null;

        head.left = prev;
        prev.right = head;

        return head;
    }

    private Node getRightMostNode(Node root, Node curr){
        while(root.right != null && root.right != curr){
            root = root.right;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};