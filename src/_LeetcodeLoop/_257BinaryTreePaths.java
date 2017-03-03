package _LeetcodeLoop;

import Tree.TreeNode;
import Tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by epttwxz on 03/03/17.
 */
public class _257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root!=null) {
            if(root.left==null&&root.right==null)
                paths.add(Integer.toString(root.val));
            else {
                if(root.left!=null)
                    getPath(root.left, Integer.toString(root.val), paths);
                if(root.right!=null)
                    getPath(root.right, Integer.toString(root.val), paths);
            }
        }
        return paths;

    }
    private void getPath(TreeNode root, String curpath, List<String> paths){
        if(root.left==null && root.right==null){  // leaf node
            paths.add(curpath+"->"+Integer.toString(root.val));
            return;
        }
        if(root.left!=null)
            getPath(root.left, curpath+"->"+root.val, paths);
        if(root.right!=null)
            getPath(root.right, curpath+"->"+root.val, paths);
    }

    public static void main(String[] args) {
        System.out.println(new _257BinaryTreePaths().binaryTreePaths(TreeUtil.convertArrayToTree(new Integer[]{1,2,3})));
    }
}
