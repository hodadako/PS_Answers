import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : arr) {
            if (i % divisor == 0) {
                result.add(i);
            }
        }
        
        int[] answer = {};
        if (result.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = result.stream().mapToInt(i -> i).toArray();
            Arrays.sort(answer);
        }
        return answer;
    }
}