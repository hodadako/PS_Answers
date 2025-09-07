import java.util.*;

class Solution {
    ArrayList<ArrayList<Character>> orders = new ArrayList<>();
    
    public int solution(int n, String[] data) {
        int answer = 0;
        
        char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        permutation(friends, new ArrayList<>());
        
        for (ArrayList<Character> order : orders) {
            boolean flag = true;
            HashMap<Character, Integer> indexes = new HashMap<>();
            for (char c : order) {
                indexes.put(c, order.lastIndexOf(c));
            }
            for (String d : data) {
                int a = indexes.get(d.charAt(0));
                int b = indexes.get(d.charAt(2));
                char oper = d.charAt(3);
                int target = Character.getNumericValue(d.charAt(4));
                if (oper == '>' && Math.abs(a - b) - 1 <= target) {
                    flag = false;
                    break;
                } else if (oper == '<' && Math.abs(a - b) - 1 >= target) {
                    flag = false;
                    break;
                } else if (oper == '=' && Math.abs(a - b) - 1 != target) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void permutation(char[] friends, ArrayList<Character> list) {
        if (list.size() == 8) {
            orders.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < friends.length; i++) {
            if (list.contains(friends[i])) continue;
            list.add(friends[i]);
            permutation(friends, list);
            list.remove(list.size() - 1);
        }
    }
}