class Solution {
    private int[] board = new int[12];
    private int count = 0;
    
    private boolean check(int index) {
        for (int i = 0; i < index; i++) {
            if (board[index] == board[i] || index - i == Math.abs(board[index] - board[i])) {
                return false;
            }
        }
        return true;
    }
    
    private void nQueen(int index, int n) {
        if (index == n) {
            count++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            board[index] = i;
            if (check(index)) {
                nQueen(index + 1, n);
            }
        }
    }
    
    public int solution(int n) {
        nQueen(0, n);
        return count;
    }
}