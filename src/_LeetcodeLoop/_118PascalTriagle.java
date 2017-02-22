package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class _118PascalTriagle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTr = new ArrayList<>();
        List<Integer> cur_line = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            cur_line.add(0, 1);
            for (int j = 1; j < i; j++) {
                cur_line.set(j, cur_line.get(j)+cur_line.get(j+1));
            }
            pascalTr.add(new ArrayList<>(cur_line));
        }
        return pascalTr;
    }
}


