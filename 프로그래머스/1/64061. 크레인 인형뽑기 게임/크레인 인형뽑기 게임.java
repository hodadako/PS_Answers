import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int h = board.length;
        
        LinkedList<Integer> stack = new LinkedList<>();
        
        for (int i: moves) {
            int index = -1;
            for (int j = 0; j < h; j++) {
                if (board[j][i - 1] > 0) {
                    index = j;
                    break;
                }
            }
            
            if (index != -1) {
                if (!stack.isEmpty() && stack.getLast() == board[index][i - 1]) {
                    answer += 2;
                    stack.removeLast();
                } else {
                    stack.add(board[index][i - 1]);
                }
                board[index][i - 1] = 0;
            } 
        }
        return answer;
    }
}