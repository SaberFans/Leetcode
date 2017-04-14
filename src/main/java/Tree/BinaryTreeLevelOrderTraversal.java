package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Level Order Traversal.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        if (root != null) {
            nodes.add(root);
            int width = 1;
            while (!nodes.isEmpty()) {
                int tmp = width;
                width = 0;
                List<Integer> level = new ArrayList<>();
                for (int i = tmp; i > 0; i--) {
                    root = nodes.remove(0);
                    level.add(root.val);
                    if (root.left != null) {
                        nodes.add(root.left);
                        width++;
                    }
                    if (root.right != null) {
                        nodes.add(root.right);
                        width++;
                    }
                }
                levels.add(level);
            }

        }


        return levels;
    }

    /**
     * DFS, recursive solution.
     * FYI. T(N) = O(N), n denotes the number of nodes.
     */
    public void levelOrder(int level, int curLevel, TreeNode root, List<Integer> levelK){
        if(root==null)
            return;
        if(level==curLevel){
            levelK.add(root.val);
            return;
        }
        levelOrder(level, curLevel+1, root.left, levelK);
        levelOrder(level, curLevel+1, root.right, levelK);
    }
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        int height = height(root);
        List<List<Integer>> levels = new ArrayList<>();
        for(int i=1;i<=height;i++){
            List<Integer> level = new ArrayList<>();
            levelOrder(i, 1, root, level);
            levels.add(level);
        }
        return levels;

    }
    int height(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(height(root.left), height(root.right))+1;
    }
}
