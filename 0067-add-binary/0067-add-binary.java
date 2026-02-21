import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger a1 = new BigInteger(a, 2);
        BigInteger a2 = new BigInteger(b, 2);
        return a1.add(a2).toString(2);
    }
}