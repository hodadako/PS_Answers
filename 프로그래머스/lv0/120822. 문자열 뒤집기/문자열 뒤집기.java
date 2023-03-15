class Solution {
    public String solution(String my_string) {
        String answer = "";
        int length = my_string.length();
        
        StringBuilder sb = new StringBuilder(my_string);
        
        for (int i = 0; i < length / 2; i++) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(length - i - 1));
            sb.setCharAt(length - i - 1, tmp);
        }
        
        answer = sb.toString();
        return answer;
    }
}