import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.split("x");
        ArrayList<String> result = new ArrayList<>();
        for (String s : answer) {
            if (!s.equals("")) {
                result.add(s);
            }
        }
        
        answer = result.toArray(new String[result.size()]);  
        Arrays.sort(answer); 
        return answer;
    }
}