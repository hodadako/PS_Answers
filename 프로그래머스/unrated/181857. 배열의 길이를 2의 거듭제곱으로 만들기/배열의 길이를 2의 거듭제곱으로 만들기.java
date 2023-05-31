import java.util.*;

class Solution {
    public int[] targets = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
    public int check(int n) {
        int target = 0;
        for (int i = targets.length - 1; i >= 0; i--) {
            if (n <= targets[i]) {
                target = targets[i];
            }
        }
        return target;
    }
    
    public int[] solution(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < check(n); i++) {
            if (i < n) {
                result.add(arr[i]);
            } else {
                result.add(0);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}