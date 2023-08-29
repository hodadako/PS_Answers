import java.util.*;

class Solution {
    class Node {
        HashMap<Integer, Integer> lenMap = new HashMap<>();
        HashMap<Character, Node> childNode = new HashMap<>(); 
    }
    
    class Trie {
        Node root = new Node();
        
        void insert(String word, int index, Node node) {
            int length = word.length() - index;
            if (node == null) {
                node = this.root;
                node.lenMap.put(length, node.lenMap.getOrDefault(length, 0) + 1);
                if (!node.childNode.containsKey(word.charAt(index))) {
                    node.childNode.put(word.charAt(index), new Node());
                }
                insert(word, index + 1, node.childNode.get(word.charAt(index)));
            } else if (length > 0) {
                node.lenMap.put(length, node.lenMap.getOrDefault(length, 0) + 1);
                if (!node.childNode.containsKey(word.charAt(index))) {
                    node.childNode.put(word.charAt(index), new Node());
                }
                insert(word, index + 1, node.childNode.get(word.charAt(index)));
            }
        }
        
        int search(String word)  {
            Node node = this.root;

            if (!node.lenMap.containsKey(word.length())) return 0;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == '?') {
                    return node.lenMap.getOrDefault(word.length() - i, 0);
                } else if (word.charAt(i) != '?' && node.childNode.get(word.charAt(i)) == null)  {
                    return 0;
                } else {
                    node = node.childNode.get(word.charAt(i));
                }
            }

            return 0;
        }
    }
    
    public int[] solution(String[] words, String[] queries) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Trie> tries = new HashMap<>(); 
        HashMap<Integer, Trie> reverseTries = new HashMap<>();
        for (String s : words) {
            if (!tries.containsKey(s.length())) {
                tries.put(s.length(), new Trie());
                reverseTries.put(s.length(), new Trie());
            }
            tries.get(s.length()).insert(s, 0, null);
            reverseTries.get(s.length()).insert(new StringBuilder(s).reverse().toString(), 0, null);
        }
        
        for (String q : queries) {
            if (tries.get(q.length()) == null) {
                answer.add(0);
                continue;
            }
            if (q.startsWith("?")) {
                answer.add(reverseTries.get(q.length()).search(new StringBuilder(q).reverse().toString()));
            } else {
                answer.add(tries.get(q.length()).search(q));
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}