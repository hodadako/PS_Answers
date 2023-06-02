import java.math.*;

class Solution {
    public String solution(String a, String b) {
        BigInteger a1 = new BigInteger(a);
        BigInteger a2 = new BigInteger(b);
        BigInteger result = a1.add(a2);
        String answer = result.toString();
        return answer;
    }
}