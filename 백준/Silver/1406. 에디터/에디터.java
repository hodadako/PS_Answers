import java.util.*;

public class Main {
    static String s;
    static LinkedList<Character> head = new LinkedList<>();
    static LinkedList<Character> tail = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        int N = sc.nextInt();
        for (int i = 0; i < s.length(); i++) {
            head.add(s.charAt(i));
        }
        
        for (int i = 0; i < N; i++) {
            String oper = sc.next();
            if (oper.equals("P")) {
                String input = sc.next();
                add(input);
            } else if (oper.equals("L")) {
                moveCursorLeft();
            } else if (oper.equals("D")) {
                moveCursorRight();
            } else {
                delete();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!head.isEmpty()) {
            sb.append(head.removeFirst());
        }
        
        while(!tail.isEmpty()) {
            sb.append(tail.removeFirst());
        }
        System.out.println(sb.toString());
    }
    
    private static void moveCursorLeft() {
        if (head.isEmpty()) {
            return;
        }
        tail.addFirst(head.removeLast());
    }
    
    private static void moveCursorRight() {
        if (tail.isEmpty()) {
            return;
        }
        head.addLast(tail.removeFirst());
    }
    
    private static void delete() {
        if (head.isEmpty()) {
            return;
        }
        head.removeLast();
    }
    
    private static void add(String input) {
        head.addLast(input.charAt(0));
    }
}
