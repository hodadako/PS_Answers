import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> treeMap = new HashMap<>();
        for (int i : array) {
            treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        }
        int max = 0;
        List<Integer> numList = new ArrayList<>();
        for (Integer i : treeMap.keySet()) {
            max = Math.max(max, treeMap.get(i));
        }
        
        for (Integer i : treeMap.keySet()) {
            if (max == treeMap.get(i)) {
                numList.add(i);
            }
        }
     
        return numList.size() >= 2 ? -1 : numList.get(0);
    }
}