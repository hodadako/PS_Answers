import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                for (int j = 0; j < arr[i] * 2; j++) {
                    result.add(arr[i]);
                }
            } else {
                for (int j = 0; j < arr[i]; j++) {
                    result.removeLast();
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}