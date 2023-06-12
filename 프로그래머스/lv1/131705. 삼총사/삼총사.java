import java.util.*;

class Solution {
    private int answer = 0;
    private void combination(ArrayList<Integer> list, int[] number, int index, int count) {
        if (count == 0) {
            int total = 0;
            for (int i = 0; i < list.size(); i++) {
                total += list.get(i);
            } 
            if (total == 0) {
                answer++;
            }
            return;
        }
            for (int i = index; i < number.length; i++) {
                list.add(number[i]);
                combination(list, number, i + 1, count - 1);
                list.remove(list.size() - 1);
            }

    }
    public int solution(int[] number) {
        combination(new ArrayList<Integer>(), number, 0, 3);
        return answer;
    }
}