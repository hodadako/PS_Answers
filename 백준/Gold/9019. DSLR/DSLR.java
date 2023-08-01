import java.util.*;

class Main {
    static char[] orders = {'D', 'S', 'L', 'R'};
    static boolean control = true;
    static boolean[] visited = new boolean[10000];

    static class Node {
        int start;
        StringBuilder result;

        public Node(int start, StringBuilder result) {
            this.start = start;
            this.result = result;
        }
    }

    private static int solve(int start, char order) {
        if (order == 'D') {
            start *= 2;
            if (start > 9999) start %= 10000;
            return start;
        } else if (order == 'S') {
            if (start == 0) {
                start = 9999;
            } else {
                start--;
            }
            return start;
        } else if (order == 'L') {
            return (start % 1000) * 10 + start / 1000;
        } else {
            return start / 10 + start % 10 * 1000;
        }
    }
    private static String bfs(int start, int end, StringBuilder list) {
        LinkedList<Node> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        q.add(new Node(start, list));
        visited[start] = true;
        while (!q.isEmpty() && control) {
            Node node = q.removeFirst();
            StringBuilder sb = node.result;
            for (int i = 0; i < 4; i++) {
                int cur = solve(node.start, orders[i]);
                StringBuilder temp = new StringBuilder(sb);
                temp.append(orders[i]);
                if (visited[cur]) continue;
                visited[cur] = true;
                if (cur == end) {
                    result = temp;
                    control = false;
                } else {
                    q.add(new Node(cur, temp));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int start = sc.nextInt(), end = sc.nextInt();
            String answer = bfs(start, end, new StringBuilder());
            control = true;
            visited = new boolean[10000];
            System.out.println(answer);
        }
    }
}