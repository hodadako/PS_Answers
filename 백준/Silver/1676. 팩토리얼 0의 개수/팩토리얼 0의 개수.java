import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String strRes = "";
        BigInteger result = new BigInteger("1");
        int answer = 0;

        if (n > 0) {
            for (int i = 1; i < n + 1; i++) {
                BigInteger tmp = BigInteger.valueOf(i);
                result = result.multiply(tmp);
            }
        }
        strRes = String.valueOf(result);
        for (int i = strRes.length() - 1 ; i > 0; i--) {
            if (strRes.charAt(i) == '0') {
                answer += 1;
            } else {
                break;
            }
        }
        
        System.out.println(answer);
    }
}