import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> o1[col - 1] == o2[col - 1] ? o2[0] - o1[0] : o1[col - 1] - o2[col - 1]);
        // for (int i = 0; i < data.length; i++) {
        //     for (int j = 0; j < data[0].length; j++) {
        //         System.out.print(data[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = row_begin; i <= row_end; i++) {
            int total = 0;
            for (int j = 0; j < data[i - 1].length; j++) {
                total += data[i - 1][j] % i;
            }
            result.add(total);
        }
        // System.out.println(result);
        int answer = result.get(0);
        for (int i = 1; i < result.size(); i++) {
            answer = answer ^ result.get(i);
        }
        return answer;
    }
}