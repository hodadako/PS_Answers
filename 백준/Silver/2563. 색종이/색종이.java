import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[][] maps = new int[100][100];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = b - 1; j < b + 9; j++){
                for (int k = a - 1; k < a + 9; k++) {
                    if (maps[j][k] != 1) {
                        maps[j][k] = 1;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < 100 ; i++) {
            for (int j = 0; j < 100; j++) {
                if (maps[i][j] == 1) {
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}