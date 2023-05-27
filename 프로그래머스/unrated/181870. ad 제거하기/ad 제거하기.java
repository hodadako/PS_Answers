import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : strArr) {
            if (!s.contains("ad")) {
                result.add(s);
            }
        }
        String[] answer = result.toArray(new String[result.size()]);
        return answer;
    }
}