package _LeetcodeLoop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yang on 2017/2/25.
 */
public class _119PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex>=0) {
            rowIndex = rowIndex+1;
            Integer rows[] = new Integer[rowIndex];
            rows[rowIndex-1] = 1;
            for (int i = 1; i < rowIndex; i++) {
                rows[rowIndex-1-i] = 1;
                for(int j = 0; j<i-1; j++){
                    rows[rowIndex -i + j] = rows[rowIndex -i + j]+ rows[rowIndex -i + j + 1];
                }
            }
            return Arrays.asList(rows);
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        for( int i=1;i<5;i++)
            System.out.println(new _119PascalTriangleII().getRow(i));
    }
}
