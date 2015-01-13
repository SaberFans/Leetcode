package Backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Gray Code stands for a successive values which differ only in one bit
 * Given n = 2, return [0,1,3,2]
 * 0 - 00
 * 1 - 01
 * 3 - 11
 * 2 - 10
 */
public class GrayCode {
    void generateGrayCode(int grayvalue, boolean checker[], List<Integer> graynums, int n) {
        if (graynums.size() == checker.length)
            return;

        for (int i = 0; i < n; i++) {
            int diff = (int) Math.pow(i, 2);
            int next = grayvalue - diff;

            if (next > 0) {
                if (checker[next]==false) {

                    graynums.add(next);
                    checker[next] = true;
                    generateGrayCode(next, checker, graynums, n);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int diff = (int) Math.pow(i, 2);
            int next = grayvalue + diff;
            if (next < graynums.size()) {
                if (checker[next]==false) {
                    graynums.add(next);
                    checker[next] = true;
                    generateGrayCode(next, checker,graynums, n);
                }
            }

        }

    }

    public List<Integer> grayCode(int n) {
        List<Integer> graynums = new ArrayList<>();
        int count = (int)Math.pow(n, 2);
        boolean checker[] = new boolean[count];
        Arrays.fill(checker, false);

        generateGrayCode(0, checker, graynums, (int) Math.pow(n, 2));


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
