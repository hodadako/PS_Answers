import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        Integer[] avg = new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            avg[i] = score[i][0] + score[i][1];
        }
        List<Integer> tmp = Arrays.asList(avg);
        System.out.println(tmp);
        TreeSet<Integer> set = new TreeSet<Integer>(tmp);
        ArrayList<Integer> key = new ArrayList<Integer>(set);
        Collections.sort(key, Collections.reverseOrder());
        System.out.println(key);
        int k = 0;
        int currentRank = 1;
        int count = 0;
        while (k < key.size()) {
            int p = key.get(k);
            for (int i = 0; i < avg.length; i++) {
                if (avg[i] == p) {
                    answer[i] = currentRank;
                    count += 1;
                }
            }
            currentRank += count;
            count = 0;
            k += 1;
        }

        
        return answer;
    }
}