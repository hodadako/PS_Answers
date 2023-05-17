import java.util.TreeMap;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < operations.length; i++) {
            String[] oper = operations[i].split(" ");
            if (oper[0].equals("I")) {
                map.put(Integer.parseInt(oper[1]), i);
            } else {
                if (oper[1].equals("-1")) {
                    map.pollFirstEntry();
                } else {
                    map.pollLastEntry();
                }
            }
        }
        int[] answer = new int[2];
        if (!map.isEmpty()) {
            answer[0] = map.lastKey();
            answer[1] = map.firstKey();
        } 
        
        return answer;
    }
}