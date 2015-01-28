package Tree;

/**
 * Sum of Root to Leaf numbers.
 */
public class SumRootToLeafNumbers {

    public int calculateValue(TreeNode root, int multiplier, int val){
        if(root==null)
            return val;

        int curVal = val + root.val*multiplier;

        multiplier = multiplier*10;
        if(root.left==null && root.right==null)
            return curVal;
        if(root.left==null)
            return calculateValue(root.right, multiplier, curVal);
        if(root.right==null)
            return calculateValue(root.left, multiplier, curVal);

        return calculateValue(root.left, multiplier, curVal)+calculateValue(root.right, multiplier, curVal);
    }

    public int sumNumbers(TreeNode root) {
        int sum;

        sum = calculateValue(root, 1, 0);

        return sum;
    }
}
