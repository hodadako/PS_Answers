import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int com = 0;
        int overlap = 0;
        int maxCount = 0;
        int[] index = new int[1000];
        
        for (int i = 0; i < array.length; i++){
            index[array[i]]++;
        }
        for (int i : index) maxCount = Math.max(i, maxCount);
        for (int i = 0; i < 1000; i++) {
            if (index[i] == maxCount) {
                overlap += 1;
                com = i;
            }
        }
        
        if (overlap == 1) {
            answer = com;
        } else {
            answer = -1;
        }
        return answer;
    }
}
