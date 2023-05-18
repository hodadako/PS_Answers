import java.util.HashMap;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 100;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(a, 1);
        if (map.containsKey(b)) {
            map.put(b, map.get(b) + 1);
        } else {
            map.put(b, 1);
        } 
        
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        } 
        
        if (map.containsKey(d)) {
            map.put(d, map.get(d) + 1);
        } else {
            map.put(d, 1);
        } 
        int count2 = 0, flag3 = 0, count1 = 0;
        for (Integer key: map.keySet()) {
            if (map.get(key) == 4) {
                answer = key * 1111;
            } else if (map.get(key) == 3) {
                flag3 = 1;
            } else if (map.get(key) == 2) {
                count2 += 1;
            } else {
                count1 += 1;
            }
        }
        
        if (count1 == 4) {
            for (Integer key: map.keySet()) {
                answer = Math.min(answer, key);
            }
        } else if (count2 == 2) {
            int p = 100;
            int q = 0;
            for (Integer key: map.keySet()) {
                p = Math.min(key, p);
                q = Math.max(key, q);
            }
            answer = (p + q) * (Math.abs(p - q));
        } else if (flag3 == 1) {
            int p = 0, q = 0;
            for (Integer key : map.keySet()) {
                if (map.get(key) == 3) {
                    p = key;
                } else {
                    q = key;
                }
            }
            answer = (10 * p + q) * (10 * p + q);
        } else if (count2 == 1) {
            int p = 0, q = 0, r = 100;
            for (Integer key : map.keySet()) {
                if (map.get(key) == 2) {
                    p = key;
                } else {
                    q = Math.max(q, key);
                    r = Math.min(r, key);
                }
            }
            answer = q * r;
        }
        
        return answer;
    }
}