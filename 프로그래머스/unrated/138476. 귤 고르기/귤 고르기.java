import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int[][] tanCount = new int[map.size()][2];
        int index = 0;
        for (int j : map.keySet()) {
            tanCount[index][0] = j;
            tanCount[index][1] = map.get(j);
            index++;
        }

        Arrays.sort(tanCount, (o1, o2) -> o2[1] - o1[1]);

        int total = 0; 
        int answer = 0;
        for (int i = 0; i < tanCount.length; i++) {
            total += tanCount[i][1];
            answer++;
            if (total >= k) {
                break;
            }
        }

        return answer;
    }
}