class Solution {
    public int solution(String binomial) {
        String[] result = binomial.split(" ");
        int answer = 0;
        int a = Integer.parseInt(result[0]);
        int b = Integer.parseInt(result[2]);
        if (result[1].equals("+")) {
            answer = a + b;
        } else if (result[1].equals("-")) {
            answer = a - b;
        } else {
            answer = a * b;
        }

        return answer;
    }
}