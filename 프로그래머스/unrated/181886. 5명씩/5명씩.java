import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        ArrayList<String> result = new ArrayList<>();

        int index = 0;
        while (index < names.length) {
            result.add(names[index]);
            index += 5;
        }
        String[] answer = result.toArray(new String[result.size()]);
        return answer;
    }
}