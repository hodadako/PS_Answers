class Solution {
    String translate(String numbers) {
        int i = 0;
        String result = "";
        while (i != numbers.length()) {
            char currentChar = numbers.charAt(i);
            if (currentChar == 'z') {
                result += "0";
                i += 4;
            } else if (currentChar == 'o') {
                result += "1";
                i += 3;
            } else if (currentChar == 't' && numbers.charAt(i + 1) == 'w') {
                result += "2";
                i += 3;
            } else if (currentChar == 't' && numbers.charAt(i + 1) == 'h') {
                result += "3";
                i += 5;
            } else if (currentChar == 'f' && numbers.charAt(i + 1) == 'o') {
                result += "4";
                i += 4;
            } else if (currentChar == 'f' && numbers.charAt(i + 1) == 'i') {
                result += "5";
                i += 4;
            } else if (currentChar == 's' && numbers.charAt(i + 1) == 'i') {
                result += "6";
                i += 3;
            } else if (currentChar == 's' && numbers.charAt(i + 1) == 'e') {
                result += "7";
                i += 5;
            } else if (currentChar == 'e') {
                result += "8";
                i += 5;
            } else if (currentChar == 'n') {
                result += "9";
                i += 4;
            } 
        }
        return result;
    }
    public long solution(String numbers) {
        String answerStr = translate(numbers);
        long answer = Long.parseLong(answerStr);
        return answer;
    }
}