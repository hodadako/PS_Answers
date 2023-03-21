import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] map = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = sc.nextInt();
            count[i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (map[j] > map[i]) {
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
        }
        int max = count[0];
        for (int i = 1; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
            } 
        }
        System.out.println(n - max);
    }
}