import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for (int i = 0; i < my_string.length(); i++)  {
            int k = Character.getNumericValue(my_string.charAt(i));
            if (k >= 0 && k < 10) {
                answer += k;
            }
        }
        return answer;
    }
}