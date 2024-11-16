import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        long result = 1;
        int countTwo = 0, countFive = 0;

        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num % 2 == 0) {
                countTwo++;
                num /= 2;
            }
            while (num % 5 == 0) {
                countFive++;
                num /= 5;
            }

            result = (result * num) % 100000; 
        }

        int extraTwos = countTwo - countFive;
        for (int i = 0; i < extraTwos; i++) {
            result = (result * 2) % 100000;
        }

        System.out.println(result % 10);
    }
}
