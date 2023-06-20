import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        for (int i = land.length - 1; i > 0; i--) {
            for (int j = 0; j < 4; j++) {
                int cur = 0; 
                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        cur = Math.max(land[i][k], cur);
                    }
                }
                land[i - 1][j] += cur;
            }
        }
        
        for (int i = 0; i < land[0].length; i++) {
            answer = Math.max(land[0][i], answer);
        }
        return answer;
    }
}