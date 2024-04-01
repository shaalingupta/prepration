


import java.util.*;

/**
 * Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Example 2:
 *
 *
 * Input: root = [3,9,8,4,0,1,7]
 * Output: [[4],[9],[3,0,1],[8],[7]]
 * Example 3:
 *
 *
 * Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
 * Output: [[4],[9,5],[3,0,1],[8,2],[7]]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

public class BinaryTreeVerticalOrderTraversal {

    class Pair{
        TreeNode node;
        int level;

        Pair(){}
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        ArrayDeque<Pair> pq = new ArrayDeque<>();
        pq.add(new Pair(root, 0));
        int level = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 0, min = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            root = curr.node;
            level = curr.level;

            if(root != null){
                map.computeIfAbsent(level, k -> new ArrayList<>()).add(root.val);
                min = Math.min(min, level);
                max = Math.max(max, level);

                pq.add(new Pair(root.left, level-1));
                pq.add(new Pair(root.right, level+1));
            }
        }

        for(int i=min; i<=max; i++){
            res.add(map.get(i));
        }
        return res;
    }
}


