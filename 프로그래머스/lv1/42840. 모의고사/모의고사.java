import java.util.*;

class Solution {
    private int[] one = {1, 2, 3, 4, 5};
    private int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    private int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {

        ArrayList<Integer> result = new ArrayList<>();
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % 5]) {
                sum1++;
            } 
            if (answers[i] == two[i % 8]) {
                sum2++;
            }
            if (answers[i] == three[i % 10]) {
                sum3++;
            }
        }
        int max = Math.max(sum3, Math.max(sum1, sum2));
        int[] cont = {sum1, sum2, sum3};
        for (int i = 0; i < cont.length; i++) {
            if (max == cont[i]) {
                result.add(i + 1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}