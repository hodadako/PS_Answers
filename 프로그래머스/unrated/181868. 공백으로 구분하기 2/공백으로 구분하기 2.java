import java.util.*;


class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> result = new ArrayList<>();
        String[] answer = my_string.split(" ");
        for (String s: answer) {
            if (s.length() > 0) {
                result.add(s);
            }
        }
        
        answer = result.toArray(new String[result.size()]);
        return answer;
    }
}