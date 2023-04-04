import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Scanner;

class Main{

    private static void absHeap(int i, PriorityQueue pq, PriorityQueue negPq) {
        if (i > 0) {
            pq.add(i);
        } else if (i < 0) {
            negPq.add(i);
        } else {
            if (negPq.isEmpty() && pq.isEmpty()){
                System.out.println(0);
            } else if (negPq.isEmpty() && !pq.isEmpty()) {
                System.out.println(pq.poll());
            } else if (!pq.isEmpty() && !negPq.isEmpty()){
                int negHead = Math.abs((Integer) negPq.peek());
                int head = Math.abs((Integer) pq.peek());
                if (negHead <= head) {
                    System.out.println(negPq.poll());
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                System.out.println(negPq.poll());
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> negPq = new PriorityQueue<>(Collections.reverseOrder());
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            map[i] = data;
        }

        for (int i = 0; i < n; i++) {
            absHeap(map[i], pq, negPq);
        }
    }
}