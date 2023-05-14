import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> counter = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (counter.containsKey(clothes[i][1])) {
                counter.put(clothes[i][1], counter.get(clothes[i][1]) + 1);
            } else {
                counter.put(clothes[i][1], 1);
            }
        }
        
        for (String key : counter.keySet()) {
            answer *= counter.get(key) + 1; // 해당 종류를 안입을 경우를 더해주고
        }
        
        answer -= 1; //아무것도 안입는 경우를 빼준다.
        return answer;
    }
}