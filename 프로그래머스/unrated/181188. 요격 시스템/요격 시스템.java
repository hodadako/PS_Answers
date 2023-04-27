import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1]-o2[1];
        });
        int i = 0, j = 1;
        while (j < targets.length) {
            int curA = targets[i][0];
            int curB = targets[i][1];
            int nextA = targets[j][0];
            int nextB = targets[j][1];
            if (curA < nextB && nextA < curB) {
                j += 1;
            } else {
                answer += 1;
                i = j;
                j += 1;
            }
        }
        answer += 1;
        return answer;
    }
}