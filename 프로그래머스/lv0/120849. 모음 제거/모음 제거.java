class Solution {
    public String solution(String my_string) {
        String answer = "";
        String vowels = "aeiou";
        for (int i = 0; i < vowels.length(); i++) {
                my_string = my_string.replaceAll(String.valueOf(vowels.charAt(i)), "");
        }
        answer = my_string;
        return answer;
    }
}