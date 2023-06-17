import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> cache = new LinkedList<>();
        int answer = 0;
        for (String s : cities) {
            if (cache.contains(s.toLowerCase())) {
                answer++;
                cache.add(cache.remove(cache.indexOf(s.toLowerCase())));
            } else {
                answer += 5;
                cache.add(s.toLowerCase()); 
            }
            
            if (cache.size() > cacheSize) {
                cache.removeFirst();
            }
        }

        return answer;
    }
}