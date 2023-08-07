import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        sequence = Arrays.copyOf(sequence, sequence.length + 1);
        sequence[sequence.length - 1] = (int) 1e6;
        int start = 0, end = 0;
        int pSum = 0;
        ArrayList<int[]> result = new ArrayList<>(); 
        
        while (end < sequence.length) {
            if (pSum >= k) {
                pSum -= sequence[start];
                start++;
            } else if (pSum < k) {
                pSum += sequence[end];
                end++;
            }
            if (pSum == k) {
                result.add(new int[]{start, end - 1, end - start});
            }
        }
        // for (int[] intArr : result) {
        //     System.out.println(Arrays.toString(intArr));
        // }
        Collections.sort(result, (o1, o2) -> o1[2] - o2[2]);
        
        return new int[]{result.get(0)[0], result.get(0)[1]};
    }
}