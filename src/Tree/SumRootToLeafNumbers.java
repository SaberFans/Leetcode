package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Sum of Root to Leaf numbers.
 */
public class SumRootToLeafNumbers {

    void calculateValue(TreeNode root, List<Integer> path, List<Integer> values){
        if(root.left==null && root.right==null){
            int sum = 0;
            for(int i=path.size()-1, j=1;i>=0;i--, j*=10){
                sum += path.get(i)*j;
            }
            values.add(sum);

        }
        else if(root.left==null){
            path.add(root.right.val);
            calculateValue(root.right, path, values);
            path.remove(path.size()-1);
        }
        else if(root.right==null){
            path.add(root.left.val);
            calculateValue(root.left, path, values);
            path.remove(path.size()-1);
        }
        else{
            path.add(root.left.val);
            calculateValue(root.left, path, values);
            path.remove(path.size()-1);

            path.add(root.right.val);
            calculateValue(root.right, path, values);
            path.remove(path.size()-1);
        }


    }
    public int sumNumbers(TreeNode root) {
        int sum=0;
        List<Integer> link = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        if(root==null)
            return sum;

        link.add(root.val);
        calculateValue(root, link, values);

        for(Integer i: values){
            sum+=i;
        }
        return sum;
    }
}
