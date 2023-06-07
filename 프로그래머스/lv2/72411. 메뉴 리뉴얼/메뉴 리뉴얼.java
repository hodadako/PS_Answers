import java.util.*;

class Solution {
    private HashMap<String, Integer> map = new HashMap<>();

    private void combination(ArrayList<String> result, ArrayList<String> key, int index, int count) {
        if (count == 0) {
            map.put(String.join("", result), 0);
        }
        for (int i = index; i < key.size(); i++) {
            result.add(key.get(i));
            combination(result, key, i + 1, count - 1);
            result.remove(result.size() - 1);
        }
    }
    
    private void check(String m, String[] orders) {
        for (String k : orders) {
            boolean add = true;
            for (int i = 0; i < m.length(); i++) {
                if (!k.contains(String.valueOf(m.charAt(i)))) {
                    add = false;
                    break;
                }
            }
            
            if (add) {
                map.put(m, map.get(m) + 1);
            }
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, Integer> result = new HashMap<>();
        for (String s : orders) {
            ArrayList<String> tmp = new ArrayList<>(Arrays.asList(s.split("")));
            Collections.sort(tmp, Comparator.naturalOrder());
            for (int k : course) {
                combination(new ArrayList<String>(), tmp, 0, k);
            }
        }
        
        
        int[] maxArr = new int[course.length];
        for (String m : map.keySet()) {
            check(m, orders);
            if (map.get(m) >= 2) {
                int index = 0;
                for (int i = 0; i < course.length; i++) {
                    if (m.length() == course[i]) {
                        index = i;
                        break;
                    }
                }
                maxArr[index] = Math.max(map.get(m), maxArr[index]);
                result.put(m, map.get(m));
            } 
        }
        
        for (String m : result.keySet()) {
                int index = 0;
                for (int i = 0; i < course.length; i++) {
                    if (m.length() == course[i]) {
                        index = i;
                        break;
                    }
                }
                if (result.get(m) == maxArr[index]) {
                    answer.add(m);
                }
            }
    
        
        Collections.sort(answer, Comparator.naturalOrder());
        return answer.toArray(new String[answer.size()]);
    }
}