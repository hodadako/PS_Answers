import java.util.*;

class Main {
    public static void main(String[] args) {
        char[] code = {'D', 'C', 'B', 'A', 'E'};
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int total = 0;
            for (int j = 0; j < 4; j++) {
                total += sc.nextInt();
            }
            System.out.println(code[total]);
        }
    }
}