import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> intList = new ArrayList<>();
        int min = 1000000;
        for (int i : arr) {
            min = Math.min(i, min);
            intList.add(i);
        }
        
        intList.remove(intList.indexOf(min));
        if (intList.isEmpty()) {
            intList.add(-1);
        } 
        return intList.stream().mapToInt(i -> i).toArray();
    }
}