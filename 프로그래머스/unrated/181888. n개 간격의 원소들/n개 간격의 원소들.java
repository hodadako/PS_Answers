import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        while (index < num_list.length) {
            result.add(num_list[index]);
            index += n;
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}