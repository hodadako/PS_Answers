class Solution {
    public int solution(int price) {
        int answer = 0;
        double discount = 0;
        if (price >= 500000) {
            discount = 0.8;
            answer = (int)(price * discount);
        } else if (price < 500000 && price >= 300000) {
            discount = 0.9;
            answer = (int)(price * discount);
        } else if (price < 300000 && price >= 100000) {
            discount = 0.95;
            answer = (int)(price * discount);
        } else {
            answer = price;
        }
        return answer;
    }
}