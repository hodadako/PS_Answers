class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        String[] result = new String[my_string.length()];
        for (int i = 0; i < my_string.length(); i++) {
            result[i] = String.valueOf(my_string.charAt(i));
        }
        
        for (int i = s; i < s + (e - s + 1) / 2; i++) {
            String tmp = result[i];
            result[i] = result[e - i + s];
            result[e - i + s] = tmp;
        }
        
        answer = String.join("", result);
        return answer;
    }
}