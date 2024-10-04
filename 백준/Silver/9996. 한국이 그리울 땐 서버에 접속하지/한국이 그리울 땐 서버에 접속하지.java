import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        String[] pattern = sc.next().split("\\*");
        
        for (int i = 0; i < N; i++) {
            String now = sc.next();
            if (now.startsWith(pattern[0]) && now.endsWith(pattern[1]) && now.length() >= pattern[0].length() + pattern[1].length()) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
