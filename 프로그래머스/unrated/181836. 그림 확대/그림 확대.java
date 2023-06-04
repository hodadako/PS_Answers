import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        ArrayList<String> result = new ArrayList<>();
        for (int h = 0; h < picture.length; h++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < picture[h].length(); j++) {
                for (int i = 0; i < k; i++) {
                    sb.append(picture[h].charAt(j));
                }
            }
            
            for (int i = 0; i < k; i++) {
                result.add(sb.toString());
            }
        }
        return result.toArray(new String[result.size()]);
    }
}