import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int wild = 0;
        int same = 0;
        int diff = 0; 
        int max = 1, min = 1;
        for (int i : lottos) {
            if (i == 0) {
                wild += 1;
            } else {
                if (Arrays.stream(win_nums).anyMatch(x -> x == i)) {
                    same += 1;
                } else {
                    diff += 1;
                }
            }
        }
        
        if (wild + diff >= 5) {
            min = 6;
        } else {
            min = wild + diff + 1;
        } 
        
        if (same + wild < 2) {
            max = 6;
        } else {
            max = 7 - same - wild;
        }
        int[] answer = {max, min};
        return answer;
    }
}