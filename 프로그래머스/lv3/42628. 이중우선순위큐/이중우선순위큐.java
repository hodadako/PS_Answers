import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> negPq = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < operations.length; i++) {
            String[] oper = operations[i].split(" ");
            if (oper[0].equals("I")) {
                pq.add(Integer.parseInt(oper[1]));
                negPq.add(Integer.parseInt(oper[1]));
            } else {
                if (oper[1].equals("-1")) {
                    if (!negPq.isEmpty()) {
                        negPq.poll();
                        if (pq.size() == 1) {
                            pq.poll();
                        }
                    }
                } else {
                    if (!pq.isEmpty()) {
                        pq.poll();
                        if (negPq.size() == 1) {
                            negPq.poll();
                        }
                    }
                }
            }
        }

        int max = 0, min = (int) 1e9;
        int num;

        if (pq.size() >= negPq.size()) {
            while (!negPq.isEmpty()) {
                num = negPq.poll();
                if (pq.contains(num)) {
                    max = Math.max(max, num);
                    min = Math.min(min, num);
                }
            }
        } else {
            while (!pq.isEmpty()) {
                num = pq.poll();
                if (negPq.contains(num)) {
                    max = Math.max(max, num);
                    min = Math.min(min, num); 
                }
            }
        }

        if (min == (int) 1e9) {
            min = 0;
        }
        int[] answer = {max, min};
        return answer;
    }
}