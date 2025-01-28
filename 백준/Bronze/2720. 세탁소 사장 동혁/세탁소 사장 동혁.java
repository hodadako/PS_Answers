import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] changes = {25, 10, 5, 1};
        int TC = sc.nextInt();
        for (int i = 0; i < TC; i++) {
            int now = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < changes.length; j++) {
                sb.append(now / changes[j]);
                now %= changes[j];
                if (j != changes.length - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
