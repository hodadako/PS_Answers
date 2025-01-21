import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[][] count = new int[2][6];
        
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            int Y = sc.nextInt();
            
            count[S][Y - 1]++;
        }
        
        int answer = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[0].length; j++) {
                int now = count[i][j];
                answer += now % K != 0 ? now / K + 1 : now / K;
            }
        }
        System.out.println(answer);
    }
}
