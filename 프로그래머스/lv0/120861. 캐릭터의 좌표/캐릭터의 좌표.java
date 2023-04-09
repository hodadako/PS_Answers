class Solution {
    
    void move(String input, int[] board, int[] max) {
        if (input.equals("up")) {
            if (board[1] + 1 <= max[0]) {
                board[1] += 1;
            }
        } else if (input.equals("down")) {
            if (board[1] - 1 >= max[1]) {
                board[1] -= 1;
            }
        } else if (input.equals("right")) {
            if (board[0] + 1 <= max[2]) {
                board[0] += 1;
            }
        } else {
            if (board[0] - 1 >= max[3]) {
                board[0] -= 1;
            }
        }
    }
    
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};
        int maxUp = (board[1] - 1) / 2;
        int maxDown = -(board[1] - 1) / 2;
        int maxRight = (board[0] - 1) / 2;
        int maxLeft = -(board[0] - 1) / 2;
        int[] max = {maxUp, maxDown, maxRight, maxLeft};

        for (int i = 0; i < keyinput.length; i++) {
            move(keyinput[i], answer, max);
        }
        
        return answer;
    }
}