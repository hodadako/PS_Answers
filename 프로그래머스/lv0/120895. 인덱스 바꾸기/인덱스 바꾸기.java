class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] myStringChar = my_string.toCharArray();
        char tmp = myStringChar[num1];
        myStringChar[num1] = myStringChar[num2];
        myStringChar[num2] = tmp;
        String answer = String.valueOf(myStringChar);
        return answer;
    }
}