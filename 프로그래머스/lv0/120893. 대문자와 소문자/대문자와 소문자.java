class Solution {
    public String solution(String my_string) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            char tmp = my_string.charAt(i);
            if (Character.isLowerCase(tmp)) {
                answer += String.valueOf(Character.toUpperCase(tmp));
            } else {
                answer += String.valueOf(Character.toLowerCase(tmp));
            }
        }
        return answer;
    }
}