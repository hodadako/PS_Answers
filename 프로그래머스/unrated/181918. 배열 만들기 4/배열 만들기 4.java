import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        LinkedList<Integer> result = new LinkedList<>();
        int i = 0;
        while (i < arr.length) {
            if (result.isEmpty()) {
                result.add(arr[i]);
                i += 1;
            } else if (!result.isEmpty() && result.peekLast() < arr[i]) {
                result.addLast(arr[i]);
                i += 1;
            } else {
                result.removeLast();
            }
        }
        
        int[] stk = new int[result.size()];
        for (int j = 0; j < result.size(); j++) {
            stk[j] = result.get(j);
        }
        return stk;
    }
}