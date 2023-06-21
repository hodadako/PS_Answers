import java.util.*;

class Solution {
    public int[] solution(String s) {
        ArrayList<ArrayList<Integer>> total = new ArrayList<>();
        ArrayList<Integer> intTemp = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        String[] strArr = s.split("},\\{");
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = strArr[i].replace("{{", "");
            strArr[i] = strArr[i].replace("}}", "");
            String[] temp = strArr[i].split(",");
            for (String k : temp) {
                intTemp.add(Integer.parseInt(k));
            }
            total.add(new ArrayList<>(intTemp));
            intTemp.clear();
        }
        
        Collections.sort(total, (o1, o2) -> o1.size() - o2.size());
        
        for (int i = 0; i < total.size(); i++) {
            for (int j = 0; j < total.get(i).size(); j++) {
                if (!result.contains(total.get(i).get(j))) {
                    result.add(total.get(i).get(j));
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}