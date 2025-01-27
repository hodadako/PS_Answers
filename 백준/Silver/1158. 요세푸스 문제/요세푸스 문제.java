import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        
        int index = 0;
        while (!list.isEmpty()) {
            index = (index + K - 1) % list.size();
            sb.append(list.remove(index));
            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}