import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String[] xArr = X.split("");
        String[] yArr = Y.split("");
        
        HashMap<String, Integer> xMap = new HashMap<>();
        for (String s : xArr) {
            xMap.put(s, xMap.getOrDefault(s, 0) + 1);
        }
        
        HashMap<String, Integer> yMap = new HashMap<>();
        for (String h : yArr) {
            yMap.put(h, yMap.getOrDefault(h, 0) + 1);
        }
        
        ArrayList<String> result = new ArrayList<>();
        for (String p : xMap.keySet()) {
            if (yMap.containsKey(p)) {
                for (int i = 0; i < Math.min(xMap.get(p), yMap.get(p)); i++) {
                    result.add(p);
                }
            }
        }
        
        Collections.sort(result, Comparator.reverseOrder());
        String answer = String.join("", result);
        HashSet<String> resultSet = new HashSet<>(result);
        if (resultSet.size() == 1 && resultSet.contains("0")) {
            answer = "0";
        } else if (resultSet.isEmpty()) {
            answer = "-1";
        } 
        return answer;
    }
}