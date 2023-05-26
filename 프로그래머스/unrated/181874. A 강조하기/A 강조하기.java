class Solution {
    public String solution(String myString) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'a') {
                answer.append(Character.toUpperCase(myString.charAt(i)));
            } else if (myString.charAt(i) == 'A') {
                answer.append(myString.charAt(i));
            } else if (Character.isUpperCase(myString.charAt(i))) {
                answer.append(Character.toLowerCase(myString.charAt(i)));
            } else {
                answer.append(myString.charAt(i));
            }
        }
        return answer.toString();
    }
}