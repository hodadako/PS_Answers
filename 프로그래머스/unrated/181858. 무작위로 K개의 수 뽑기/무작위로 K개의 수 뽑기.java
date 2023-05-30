import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!result.contains(arr[i]) && k != 0) {
                result.add(arr[i]);
                k--;
            }
        }
        while (k != 0) {
            result.add(-1);
            k--;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}