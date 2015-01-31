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
}
