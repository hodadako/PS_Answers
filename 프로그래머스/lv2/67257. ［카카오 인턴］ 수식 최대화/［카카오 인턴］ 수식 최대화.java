import java.util.*;

class Solution {
    private static String expression = "100-200*300-500+20";
    private static ArrayList<Character> types = new ArrayList<>();
    private static ArrayList<Character> orders = new ArrayList<>();
    private static ArrayList<ArrayList<Character>> calcs = new ArrayList<>();
    private static ArrayList<Long> numbers = new ArrayList<>();
    private static long answer = 0;

    private static void operInit(String ex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ex.length(); i++) {
            char c = ex.charAt(i);
            if (!Character.isDigit(c)) {
                numbers.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
                if (!types.contains(c)) {
                    types.add(c);
                }
                orders.add(c);
            } else {
                sb.append(c);
            }
        }
        numbers.add(Long.parseLong(sb.toString()));
    }

    private static void permutation(ArrayList<Character> result, int count) {
        if (count == 0) {
            ArrayList<Character> addTemp = new ArrayList<>(result);
            calcs.add(addTemp);
            return;
        }

        for (int i = 0; i < types.size(); i++) {
            if (result.contains(types.get(i))) continue;
            result.add(types.get(i));
            permutation(result, count - 1);
            result.remove(result.size() - 1);
        }
    }

    private static long cal(int n) {
        long res = 0;
        ArrayList<Character> order = calcs.get(n);
        ArrayList<Character> oldOrders = new ArrayList<>(orders);
        ArrayList<Long> nums = new ArrayList<>(numbers);
        ArrayList<Character> newOrder = new ArrayList<>();
        ArrayList<Long> newNums = new ArrayList<>();
        // System.out.println("order = " + order);
        // System.out.println("_________________");
        for (int i = 0; i < order.size(); i++) {
            char c = order.get(i);
            for (int j = 0; j < nums.size() - 1; j++) {
                if (oldOrders.get(j) == c) {
                    if (c == '-') {
                        newNums.add(nums.get(j) - nums.get(j + 1));
                    } else if (c == '+') {
                        newNums.add(nums.get(j) + nums.get(j + 1));
                    } else {
                        newNums.add(nums.get(j) * nums.get(j + 1));
                    }

                    if (j < nums.size() - 2) {
                        if (oldOrders.get(j + 1) == c) {
                            nums.set(j + 1, newNums.get(newNums.size() - 1));
                            newNums.remove(newNums.size() - 1);
                        }
                    }
                } else if (j == 0 && oldOrders.get(j) != c) {
                    newNums.add(nums.get(j));
                } else if (j > 0 && oldOrders.get(j) != c) {
                    if (oldOrders.get(j - 1) != c) {
                        newNums.add(nums.get(j));
                    }
                }

                if (oldOrders.get(j) != c) {
                    newOrder.add(oldOrders.get(j));
                }
            }
            if (oldOrders.get(oldOrders.size() - 1) != c) {
                newNums.add(nums.get(nums.size() - 1));
            }

            nums = new ArrayList<>(newNums);
            oldOrders = new ArrayList<>(newOrder);
            // System.out.println("nums = " + nums);
            // System.out.println("oldOrders = " + oldOrders);
            newNums.clear();
            newOrder.clear();
        }
        res = nums.get(0);
        return Math.abs(res);
    }

    public static long solution(String expression) {
        operInit(expression);
        permutation(new ArrayList<Character>(), types.size());
         for (int i = 0; i < calcs.size(); i++) {
             if (cal(i) > answer) {
                 answer = cal(i);
             }
         }
        return answer;
    }

    public static void main(String[] args) {
        solution(expression);
        // System.out.println("answer = " + answer);
    }
}