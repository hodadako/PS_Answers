import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer, (int) 1e9);
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (arr[j] > queries[i][2]) {
                    answer[i] = Math.min(answer[i], arr[j]);
                }
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            if (answer[i] == (int) 1e9) {
                answer[i] = -1;
            }
        }
        return answer;
    }
}