class Solution {
    public static int solution(int[] a) {

        if (a.length <= 2) {
            return a.length;
        }

        int answer = 2;
        int leftMin = a[0];
        int rightMin = a[a.length - 1];
        int totalMinIndex = getMinIndex(a);

        for (int i = 1; i <= Math.min(totalMinIndex, a.length - 2); i++) {
            if (a[i] < leftMin) {
                answer++;
                leftMin = a[i];
            }
        }

        for (int i = a.length - 2; i > totalMinIndex; i--) {
            if (a[i] < rightMin) {
                rightMin = a[i];
                answer++;
            }
        }

        return answer;
    }

    private static int getMinIndex(int[] a) {
        int resultValue = a[0];
        int resultIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < resultValue) {
                resultValue = a[i];
                resultIndex = i;
            }
        }
        return resultIndex;
    }
}