import java.util.*;

class Solution {
    public LinkedList<Integer> stack = new LinkedList<>();
    public int answer = 0;
    
    public void pick(int[][] board, int[] moves) {
        for (int i : moves) {
            for (int j = 0; j < board.length; j++) {
                if(board[j][i - 1] > 0) {
                    if (!stack.isEmpty()) {
                        if (stack.peekLast() == board[j][i - 1]) {
                            answer += 2;
                            stack.removeLast();
                        } else {
                            stack.addLast(board[j][i - 1]);
                        }
                    } else {
                        stack.addLast(board[j][i - 1]);
                    }
                    board[j][i - 1] = 0;
                    break;
                }
            }
        }
    }
    
    public int solution(int[][] board, int[] moves) {
        pick(board, moves);
        return answer;
    }
}