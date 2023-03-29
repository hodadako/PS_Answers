import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int answerIdx = 0;
        int key = 1000;
        Arrays.sort(array);
        int len = array.length;
        if (len == 1) {
            answer = array[0]; 
        } else {
            for (int i = 0; i < len; i++) {
                int tmp = Math.abs(array[i] - n);
                if (key > tmp) {
                    answerIdx = i;
                    key = tmp;
                } 
            }
        }
        answer = array[answerIdx];
        return answer;
    }
}