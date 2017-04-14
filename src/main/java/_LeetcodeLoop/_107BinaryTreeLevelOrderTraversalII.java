package _LeetcodeLoop;

import Tree.TreeNode;
import Tree.TreeUtil;

import java.util.*;

/**
 * Created by epttwxz on 03/03/17.
 */
public class _107BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom_bfs(TreeNode root){
        List<List<Integer>> nodesLinkedList = new LinkedList<>();
        Deque<TreeNode> nodes = new LinkedList<>();
        if(root!=null){
            nodes.offer(root);
            while(!nodes.isEmpty()){
                int width = nodes.size();
                List<Integer> curlevel = new ArrayList<>();
                for(int i=0;i<width;i++){
                    if(nodes.peek().left!=null) nodes.addLast(nodes.peek().left);
                    if(nodes.peek().right!=null) nodes.addLast(nodes.peek().right);
                    curlevel.add(nodes.poll().val);
                }
                nodesLinkedList.add(0, curlevel);
            }
        }
        return nodesLinkedList;
    }
    public List<List<Integer>> levelOrderBottom_dfs(TreeNode root){
        List<List<Integer>> nodelist = new LinkedList<>();
        dfsLevelTravel(root, 0, nodelist);
        return nodelist;
    }
    private void dfsLevelTravel(TreeNode root, int level, List<List<Integer>> nodelist){
        if(root!=null){
            if(level==nodelist.size())
                nodelist.add(0, new ArrayList<Integer>());
            dfsLevelTravel(root.left, level+1, nodelist);
            dfsLevelTravel(root.right, level+1, nodelist);
            nodelist.get(nodelist.size()-1-level).add(root.val);
        }
    }

    public static void main(String[] args) {
        System.out.println("========BFS=======");
        System.out.println(new _107BinaryTreeLevelOrderTraversalII().
                levelOrderBottom_bfs(TreeUtil.convertArrayToTree(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println("========DFS=======");
        System.out.println(new _107BinaryTreeLevelOrderTraversalII().
                levelOrderBottom_dfs(TreeUtil.convertArrayToTree(new Integer[]{3,9,20,null,null,15,7})));


    }

}
