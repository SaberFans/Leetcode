package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Level order bottom up, left to right.
 */
public class BinaryLevelOrderTraversal_II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        if(root==null)
            return levels;

        List<TreeNode> level = new ArrayList<>();
        level.add(root);

        while(level.size()>0){
            int curBreath = level.size();
            List<Integer> tmp = new ArrayList<>();
            while(curBreath>0){

                TreeNode node = level.remove(0);
                tmp.add(node.val);
                if(node.left!=null)
                    level.add(node.left);
                if(node.right!=null)
                    level.add(node.right);
                curBreath--;
            }

            levels.add(tmp);

        }
        //reverse the list
        Collections.reverse(levels);

        return levels;

    }
}
