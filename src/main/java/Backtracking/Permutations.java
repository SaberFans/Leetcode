package Backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given a collection of numbers, return all permutations.
 *
 */
public class Permutations {

    public void generatePermutations(List<List<Integer>> perms, List<Integer> set, List<Integer> indexes, int depth, int n){
        if(depth==n){
            perms.add(set);
            return;
        }
        for(int i=0;i<indexes.size();i++){
            List<Integer> copy = new ArrayList<>(set);
            List<Integer> indexescp = new ArrayList<>(indexes);
            copy.add(indexes.get(i));
            indexescp.remove(i);

            generatePermutations(perms, copy, indexescp, depth+1, n);

        }
    }

    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        List<Integer> indexes = new ArrayList<>();
        for(int i=0;i<num.length;i++){
            indexes.add(num[i]);
        }

        generatePermutations(ll, set,indexes, 0, num.length);

        return ll;
    }


    @Test
    public void test(){
        System.out.println(permute(new int[]{1, 2, 3}));
    }


}
