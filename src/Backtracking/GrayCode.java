package Backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Gray Code stands for a successive values which differ only in one bit
 * Given n = 2, return [0,1,3,2]
 * 0 - 00
 * 1 - 01
 * 3 - 11
 * 2 - 10
 */
public class GrayCode {
    void generateGrayCode(int grayvalue, HashSet<Integer> checker, List<Integer> graynums, int size, int n) {
        if (graynums.size() == size)
            return;

        for (int i = 0; i < n; i++) {
            int next = grayvalue - (int) Math.pow(i, 2);

            if (next > 0) {
                if (!checker.contains(next)) {

                    graynums.add(next);
                    checker.add(next);
                    generateGrayCode(next, checker, graynums, size, n);
                }
            }
            next = grayvalue + (int) Math.pow(i, 2);
            if (next < size) {
                if (!checker.contains(next)) {
                    graynums.add(next);
                    checker.add(next);
                    generateGrayCode(next, checker,graynums, size, n);
                }
            }
        }
    }

    public List<Integer> grayCode(int n) {
        List<Integer> graynums = new ArrayList<>();

        generateGrayCode(0, new HashSet<Integer>(), graynums, (int) Math.pow(n, 2), n);


        return graynums;
    }

    @Test
    public void test() {
        System.out.println(grayCode(2).toString());
    }

    @Test
    public void test2(){


    }


}
