package xmas2018;
import java.util.Arrays;
import java.util.List;

public class Quicksort{
    public <T extends Comparable<T>> void sort(List<T> list){
        sort(list, 0, list.size()-1);
    }
    private <T extends Comparable<T>> void sort(List<T> list, int start, int end){
        if(start>=end)
            return;
        int pivot = findPivot(list, start, end);
        sort(list, start, pivot-1);
        sort(list, pivot+1, end);
    }
    // 3 4 5 1 2 - 3
    // 1 4 5 3 2
    // 1 2 5 3 4 
    private <T extends Comparable<T>> int findPivot(List<T> list, int start, int end){
        int pivot = end;
        T pivotVal = list.get(pivot);
        int replaced = start;
        while(start<pivot){
            if(list.get(start).compareTo(pivotVal) <= 0){
                T swap = list.get(replaced);
                list.set(replaced, list.get(start));
                list.set(start, swap);
                replaced++;
            }
            start++;
        }    
        T swap = list.get(pivot);
        list.set(pivot, list.get(replaced));
        list.set(replaced, swap);

        return replaced;
    }

    public static void main(String[] args) {
        Quicksort qs = new Quicksort();
        List<Integer> list = Arrays.asList(5,4,3,2,1);
        System.out.println("Beforing sorting: ");
        list.stream().forEach(c-> System.out.print(c+" "));

        qs.sort(list);

        System.out.println("\nAfter sorting: ");
        list.stream().forEach(c-> System.out.print(c+" "));

    }
}