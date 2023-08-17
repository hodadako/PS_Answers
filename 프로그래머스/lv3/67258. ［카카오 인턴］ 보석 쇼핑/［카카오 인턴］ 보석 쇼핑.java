import java.util.*;

class Solution {
    HashSet<String> set = new HashSet<>();
    int n;
    public int[] solution(String[] gems) {
        int[] answer = {};
        n = gems.length;
        for (String s : gems) {
            set.add(s);
        }
        
        int start = 0, end = n;
        int s = 0, e = 0;
        HashMap<String, Integer> count = new HashMap<>();
        count.put(gems[s], 1);
        while (s < n) {
            if (set.size() == count.keySet().size()) {
                if (e - s < end - start) {
                    end = e;
                    start = s;
                }
                
                count.put(gems[s], count.get(gems[s]) - 1);
                if (count.get(gems[s]) == 0) {
                    count.remove(gems[s]);
                }
                s++;
            } else if (e < n - 1) {
                e++;
                count.put(gems[e], count.getOrDefault(gems[e], 0) + 1);
            } else {
                break;
            }
        }
        return new int[]{start + 1, end + 1};
    }
}