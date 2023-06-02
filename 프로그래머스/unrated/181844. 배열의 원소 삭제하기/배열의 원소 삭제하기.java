import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i : arr) {
            tmp.add(i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i++) {
            boolean add = true;
            for (int j = 0; j < delete_list.length; j++) {
                if(tmp.get(i) == delete_list[j]) {
                    add = false;
                }
            }
            
            if (add) {
                result.add(tmp.get(i));
            }
        }
        int[] answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}