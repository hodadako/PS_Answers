import java.util.*;

class Solution {
    public static int[] solution(int[][] dice) {
        int n = dice.length;
        int halfN = n / 2;
        List<int[]> allCombinations = new ArrayList<>();
        generateCombinations(n, halfN, 0, new ArrayList<>(), allCombinations);

        double bestProb = -1;
        int[] bestCombination = null;

        for (int[] aIndices : allCombinations) {
            Set<Integer> aSet = new HashSet<>();
            for (int idx : aIndices) aSet.add(idx);

            List<Integer> bIndices = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!aSet.contains(i)) {
                    bIndices.add(i);
                }
            }

            Map<Integer, Integer> aScores = getScoreDistribution(dice, aIndices);
            Map<Integer, Integer> bScores = getScoreDistribution(dice, bIndices.stream().mapToInt(i -> i).toArray());
            
            double winProb = calculateWinProbability(aScores, bScores);
            
            if (winProb > bestProb) {
                bestProb = winProb;
                bestCombination = aIndices;
            }
        }
        
        return Arrays.stream(bestCombination).map(i -> i + 1).toArray(); // 1-based index
    }

    private static void generateCombinations(int n, int k, int start, List<Integer> current, List<int[]> result) {
        if (current.size() == k) {
            result.add(current.stream().mapToInt(i -> i).toArray());
            return;
        }
        for (int i = start; i < n; i++) {
            current.add(i);
            generateCombinations(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    private static Map<Integer, Integer> getScoreDistribution(int[][] dice, int[] selectedDice) {
        Map<Integer, Integer> scoreCounts = new HashMap<>();
        generateScores(dice, selectedDice, 0, 0, scoreCounts);
        return scoreCounts;
    }

    private static void generateScores(int[][] dice, int[] selectedDice, int idx, int sum, Map<Integer, Integer> scoreCounts) {
        if (idx == selectedDice.length) {
            scoreCounts.put(sum, scoreCounts.getOrDefault(sum, 0) + 1);
            return;
        }
        for (int num : dice[selectedDice[idx]]) {
            generateScores(dice, selectedDice, idx + 1, sum + num, scoreCounts);
        }
    }

    private static double calculateWinProbability(Map<Integer, Integer> aScores, Map<Integer, Integer> bScores) {
        List<Integer> sortedBScores = new ArrayList<>(bScores.keySet());
        Collections.sort(sortedBScores);
        
        int totalA = aScores.values().stream().mapToInt(Integer::intValue).sum();
        int totalB = bScores.values().stream().mapToInt(Integer::intValue).sum();
        
        int winCount = 0;
        int cumulativeB = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        
        for (int bScore : sortedBScores) {
            prefixSum.put(bScore, cumulativeB);
            cumulativeB += bScores.get(bScore);
        }
        
        for (Map.Entry<Integer, Integer> aEntry : aScores.entrySet()) {
            int aScore = aEntry.getKey();
            int aCount = aEntry.getValue();
            
            for (int bScore : sortedBScores) {
                if (aScore > bScore) {
                    winCount += aCount * bScores.get(bScore);
                } else {
                    break;
                }
            }
        }
        
        return (double) winCount / (totalA * totalB);
    }
}