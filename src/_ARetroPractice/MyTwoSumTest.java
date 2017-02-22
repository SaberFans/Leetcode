package _ARetroPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yang on 2016/12/3.
 */
public class MyTwoSumTest {

    static void buildMap(HashMap<Integer, List<Integer>> maps, int[] list){
        for(int i=0;i<list.length;i++ ){
            if(maps.containsKey(list[i])){
                maps.get(list[i]).add(i);
            }
            else{
                List<Integer> indlist = new ArrayList<>();
                indlist.add(i);
                maps.put(list[i],indlist);
            }
        }
    }
    public static int[] findTwoSum(int[] list, int sum) {
        HashMap<Integer, List<Integer>> maps = new HashMap<>();
        buildMap(maps, list);

        if(!maps.isEmpty()){
            for(int i=0;i<list.length;i++){
                if(maps.containsKey(sum-list[i])){
                    int matchInd = maps.get(sum-list[i]).get(0);
                    if(matchInd!=i)
                        return new int[]{i, matchInd};
                    else if(maps.get(sum-list[i]).size()>1)
                        return new int[]{i, maps.get(sum-list[i]).get(1)};

                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
        System.out.println(indices[0] + " " + indices[1]);
    }
}
