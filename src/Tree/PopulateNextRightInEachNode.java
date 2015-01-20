package Tree;

import java.util.LinkedList;

import org.junit.Test;

/**
 * Populate each next pointer to its next right node. If no next right pointer
 * available, assign null.
 * 
 */
public class PopulateNextRightInEachNode {

    /**
     * Use Breadth search to do level traversal.
     * this solution is requiring more than constant space.
     * @param root
     *            top-most tree root
     */
    public void connect(TreeNode root) {
	LinkedList<TreeNode> deque = new LinkedList<>();
	if (root == null)
	    return;
	deque.push(root);
	int widthOriginal = 1;
	while (!deque.isEmpty()) {
	    int width = widthOriginal;
	    while (width-- > 0) {
		TreeNode node = deque.pollFirst();
		if(node==null)
		    continue;
		if(width > 0)
		    node.next = deque.peekFirst();
		else
		    node.next = null;
		deque.offerLast(node.left);
		deque.offerLast(node.right);
	    }

	    widthOriginal = widthOriginal * 2;
	}
    }

    /**
     * Recursive solution, provided by @author FishinWater.
     * The tree is visited one sub tree by one sub tree
     * @param root
     */
    public void connect_constantSpace(TreeNode root){
	if(root==null)
	    return;
	if(root.left!=null){
	    root.left.next = root.right;
	}
	if(root.right!=null){
	    root.right.next = root.next==null?null:root.next.left;
	}
	connect(root.left);
	connect(root.right);
    }
    
    @Test
    public void test() {
	TreeNode n1 = new TreeNode(2);
	TreeNode n2 = new TreeNode(3);
	TreeNode n3 = new TreeNode(1);
	n1.left = n2;
	n1.right = n3;
	n2.left = n2.right = n3.left = n3.right = null;
	connect(n1);
	connect_constantSpace(n1);
	System.out.println(n2.next);
    }
}
