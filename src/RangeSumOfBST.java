
import java.util.*;

/**
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 * Example 2:
 *
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 2 * 104].
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * All Node.val are unique.
 */
public class RangeSumOfBST {

    int sum = 0;
    public int rangeSumBT(TreeNode root, int low, int high) { //binary Tree
        inorder(root, low, high);
        return sum;
    }

    private void inorder(TreeNode root, int low, int high) {
        if(root==null){
            return;
        }
        inorder(root.left, low, high);
        if(root.val >= low && root.val <= high){
            sum += root.val;
        }
        inorder(root.right, low, high);
    }

    public int rangeSumBST(TreeNode root, int low, int high){
        if(root == null){
            return 0;
        }
        if (root.val < low){
            return rangeSumBST(root.right, low, high); //if node val itself is less than low means all the left of this will be less only so move to node.right
        }
        if (root.val > high){
            return rangeSumBST(root.left, low, high); // if node val itself is more than high means all the right of this will be more only so move to node.left
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high); // else move to both sides
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 5, 15, 3, 7, null, 18, null, null, null, null, null, null};
        TreeNode node = TreeNode.makeTree(arr);
        System.out.println(Arrays.toString(TreeNode.decryptTreeToArray(node)));
        int low = 7, high = 15;
        RangeSumOfBST r = new RangeSumOfBST();
        System.out.println(r.rangeSumBST(node, low, high));

    }
}

