import java.math.BigInteger;

class Solution {
    public BigInteger solution(int balls, int share) {
        BigInteger answer;
        BigInteger number = new BigInteger("1");
        BigInteger denom = new BigInteger("1");
        for (int i = share; i > 0; i--) {
            BigInteger tmp1 = BigInteger.valueOf(balls);
            BigInteger tmp2 = BigInteger.valueOf(i);
            number = number.multiply(tmp1);
            denom = denom.multiply(tmp2);
            balls -= 1;
        }
        answer = number.divide(denom);
        return answer;
    }
}