import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        ArrayList<Integer> stack = new ArrayList<>();
        for (int i : ingredient) {
            stack.add(i);
        }
        if (ingredient.length > 3) {
                    for (int i = 3; i < stack.size(); i++) {
                if (i > 2) {
                                    if (stack.get(i - 3) == 1 && stack.get(i - 2) == 2 && stack.get(i - 1) == 3 && stack.get(i) == 1) {
                    stack.remove(i);
                    stack.remove(i - 1);
                    stack.remove(i - 2);
                    stack.remove(i - 3);
                    i -= 3;
                    answer++;
                } 
                }

                
                if (stack.size() < 4) {
                    break;
                }
            }
        }

        return answer;
    }
}