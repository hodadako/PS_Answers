import java.util.*;

class Solution {
    public int solution(int[] topping) {
        LinkedList<Integer> t = new LinkedList<>();
        HashSet<Integer> chul = new HashSet<>();
        HashMap<Integer, Integer> brother = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            brother.put(topping[i], brother.getOrDefault(topping[i], 0) + 1);
            t.add(topping[i]);
        }
        int answer = 0;
        // System.out.println(brother); /
        while (!t.isEmpty()) {
            int cur = t.removeFirst();
            chul.add(cur);
            brother.put(cur, brother.get(cur) - 1);
            if (brother.get(cur) == 0) {
                brother.remove(cur);
            }
            
            if (chul.size() == brother.keySet().size()) {
                answer++;
            }
        }
        return answer;
    }
}