import java.util.*;

class Main {
    static int n, k;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        n = sc.nextInt();
        k = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int now = sc.nextInt();
            if (now < k) {
                System.out.print(now + " ");
            }
        }
    }
}