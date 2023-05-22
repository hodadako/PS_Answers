import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i <= slicer[1]; i++) {
                result.add(num_list[i]);
            }
        } else if (n == 2) {
            for (int i = slicer[0]; i < num_list.length; i++) {
                result.add(num_list[i]);
            }
        } else if (n == 3) {
            for (int i = slicer[0]; i <= slicer[1]; i++) {
                result.add(num_list[i]);
            }
        } else {
            int index = slicer[0];
            while (index <= slicer[1]) {
                result.add(num_list[index]);
                index += slicer[2];
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}