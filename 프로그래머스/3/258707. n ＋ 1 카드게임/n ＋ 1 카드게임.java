import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int target = n + 1;

        Set<Integer> hand = new HashSet<>();
        for (int i = 0; i < n / 3; i++) hand.add(cards[i]);

        int idx = n / 3;
        int round = 1;
        List<Integer> pool = new ArrayList<>();

        while (idx < n) {
            for (int i = 0; i < 2 && idx < n; i++) {
                pool.add(cards[idx++]);
            }

            boolean next = false;

            next = canProceed(hand, hand, target);
            if (next) {
                removePair(hand, target);
                round++;
                continue;
            }

            if (coin >= 1) {
                next = canProceed(hand, pool, target);
                if (next) {
                    removePair(hand, pool, target);
                    coin--;
                    round++;
                    continue;
                }
            }

            if (coin >= 2) {
                next = canProceed(pool, pool, target);
                if (next) {
                    removePair(pool, target);
                    coin -= 2;
                    round++;
                    continue;
                }
            }

            break;
        }

        return round;
    }

    private boolean canProceed(Collection<Integer> a, Collection<Integer> b, int target) {
        for (int x : a) {
            if (b != a && b.contains(target - x)) return true;
            if (b == a && a.contains(target - x) && x != target - x) return true;
        }
        return false;
    }

    private void removePair(Collection<Integer> a, int target) {
        for (int x : a) {
            if (a.contains(target - x) && x != target - x) {
                a.remove(x);
                a.remove(target - x);
                return;
            }
        }
    }

    private void removePair(Collection<Integer> a, Collection<Integer> b, int target) {
        for (int x : a) {
            if (b.contains(target - x) && x != target - x) {
                a.remove(x);
                b.remove(target - x);
                return;
            }
        }
    }
}
