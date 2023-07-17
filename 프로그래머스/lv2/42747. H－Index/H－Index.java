import java.util.*;

class Solution {
    public int solution(int[] citations) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int answer = 0;
        for (int i : citations) {
            if (i > 0) {
                for (int j = i; j > 0; j--) {
                    tm.put(j, tm.getOrDefault(j, 0) + 1);
                }
            }
        }
        System.out.println(tm);
        for (int i : tm.descendingKeySet()) {
            if (i <= tm.get(i)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}